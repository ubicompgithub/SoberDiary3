package ubicomp.soberdiary.test.gps;

import ubicomp.soberdiary3.main.R;
import ubicomp.soberdiary.main.ui.toast.CustomToastSmall;
import android.os.Handler;
import android.os.Message;

/**
 * Handler for showing toast of the GPS message
 * 
 * @author Stanley Wang
 */
public class GPSToastHandler extends Handler {

	public void handleMessage(Message msg) {
		CustomToastSmall.generateToast(R.string.open_gps);
	}
}
