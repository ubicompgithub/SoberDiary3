package ubicomp.soberdiary.system.uploader;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;

import ubicomp.soberdiary.main.App;
import ubicomp.soberdiary3.main.R;

/**
 * Generate SSL HTTP client
 * 
 * @author Stanley Wang
 */
public class HttpSecureClientGenerator {

	/**
	 * Generate SSL Http client
	 * 
	 * @return DefaultHttpClient with SSL certificate
	 */
	public static DefaultHttpClient getSecureHttpClient() {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		KeyStore trustStore;
		InputStream instream = App.getContext().getResources().openRawResource(R.raw.alcohol_certificate);
		try {
			trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(instream, null);
			SSLSocketFactory socketFactory;
			socketFactory = new SSLSocketFactory(trustStore);
			Scheme sch = new Scheme("https", socketFactory, 443);
			httpClient.getConnectionManager().getSchemeRegistry().register(sch);
			httpClient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
			HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 3000);
		} catch (Exception e) {
		} finally {
			try {
				instream.close();
			} catch (IOException e) {
			}
		}
		return httpClient;
	}
}
