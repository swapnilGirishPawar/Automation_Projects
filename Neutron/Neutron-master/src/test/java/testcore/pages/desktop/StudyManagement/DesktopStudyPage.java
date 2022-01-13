package testcore.pages.desktop.StudyManagement;

import agent.IAgent;
import central.Configuration;
import testcore.pages.StudyManagement.StudyPage;

import java.util.Map;

public class DesktopStudyPage extends StudyPage {

	public DesktopStudyPage(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
		assertPageLoad();
	}

	@Override
	public String pageName() {
		return StudyPage.class.getSimpleName();
	}
}
