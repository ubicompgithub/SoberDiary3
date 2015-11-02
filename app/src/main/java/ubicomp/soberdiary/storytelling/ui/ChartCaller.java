package ubicomp.soberdiary.storytelling.ui;

import ubicomp.soberdiary.data.structure.TimeValue;

public interface ChartCaller {
	public void setChartType(int type);
	public void closeRecorder();
	public void openRecordBox(TimeValue tv, int selected_button);
}
