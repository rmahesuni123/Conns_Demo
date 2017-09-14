package com.etouch.taf.core.config;

import java.util.List;


/**
 * The Class TestngConfig.
 */
public class TestngConfig extends TafConfig {
	
	/** The listener. */
	private String testListener;
	
	private String suiteListener;
		
	private List<TestngClass> testngClass;
	
	/** The reporter. */
	private String reporter;
	
	/** Parallel Mode */
	private String parallelMode;
	
	private String groupName;
	

	/**
	 * Gets the listener.
	 *
	 * @return the listener
	 */
	public String getTestListener() {
		return testListener;
	}
	
	/**
	 * Sets the listener.
	 *
	 * @param listener the new listener
	 */
	public void setTestListener(String testListener) {
		this.testListener = testListener;
	}
	
	
	

	public String getSuiteListener() {
		return suiteListener;
	}

	public void setSuiteListener(String suiteListener) {
		this.suiteListener = suiteListener;
	}

	/**
	 * Gets the reporter.
	 *
	 * @return the reporter
	 */
	public String getReporter() {
		return reporter;
	}

	/**
	 * Sets the reporter.
	 *
	 * @param reporter the new reporter
	 */
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	
	
	
	
	public List<TestngClass> getTestngClass() {
		return testngClass;
	}

	public void setTestngClass(List<TestngClass> testngClass) {
		this.testngClass = testngClass;
	}

	public String getParallelMode() {
		return parallelMode;
	}

	public void setParallelMode(String parallelMode) {
		this.parallelMode = parallelMode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	
	
	
	
}
