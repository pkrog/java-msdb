import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import org.openscience.msdb.MsPeakForestDb;
import org.rosuda.REngine.REngine;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.REXPMismatchException;

/**
 * @author Pierrick Roger
 */
public class TestMsDb {

	REngine rengine = null;

	///////////////////
	// START RENGINE //
	///////////////////

	@Before
	public void startREngine() throws REngineException {
		this.rengine = org.rosuda.REngine.JRI.JRIEngine.createEngine();
	}

	//////////////////
	// STOP RENGINE //
	//////////////////

	@After
	public void stopREngine() {
		if (rengine != null) {
			this.rengine.close();
			this.rengine = null;
		}
	}

	////////////////////
	// TEST MZ SEARCH //
	////////////////////

	@Test
	public void testMzSearch() throws java.net.MalformedURLException, REngineException, REXPMismatchException {
		MsPeakForestDb db = new MsPeakForestDb(this.rengine, new java.net.URL("http://rest.peakforest.org/"), "java-msdb.test ; pierrick.roger@gmail.com");
	}
}
