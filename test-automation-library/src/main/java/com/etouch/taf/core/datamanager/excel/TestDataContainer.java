package com.etouch.taf.core.datamanager.excel;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.testng.annotations.DataProvider;

import com.etouch.taf.core.exception.TafDataProviderException;

/**
 * 
 * Container to store:
 * 
 * 1. The test data in format Object[][] with {@link TestDataKey} as the key to
 * access the test data. Any TestNG {@link DataProvider} implementation that
 * reads data is expected to store the data here for sharing with other test
 * methods requiring the same data.
 * 
 * 2. The data files in a map - <file_key, absolute_path_to_fil>
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class TestDataContainer {

	/** The sInstance. */
	private static TestDataContainer sInstance = null;

	/** The data files info. */
	private Map<String, String> dataFilesInfo = new ConcurrentHashMap<>();

	/** The taf test data. */
	private Map<TestDataKey, Object[][]> tafTestData = new ConcurrentHashMap<>();

	/**
	 * Empty, no-parameter private constructor for creating singleton.
	 */
	private TestDataContainer() {
	}

	/**
	 * Returns the singleton instance of this class.
	 * 
	 * @return single instance of TestDataContainer
	 */
	public static TestDataContainer getInstance() {

		if (sInstance == null) {
			synchronized (TestDataContainer.class) {
				sInstance = new TestDataContainer();
			}
		}

		return sInstance;
	}

	/**
	 * Adds the test data object 2d array [][] with specified
	 * {@link TestDataKey} as key to the underlying map.
	 * 
	 * @param testDataKey
	 *            the test data key
	 * @param testData
	 *            the test data
	 * @return true, if successful
	 */
	public boolean addTestData(TestDataKey testDataKey, Object[][] testData) {
		return tafTestData.put(testDataKey, testData) != null;
	}

	/**
	 * Gets the test data object .
	 * 
	 * @param testDataKey
	 *            the test data key
	 * @return the test data
	 */
	public Object[][] getTestData(TestDataKey testDataKey) {
		return tafTestData.get(testDataKey);
	}

	/**
	 * Checks if the container already has the test data loaded.
	 * 
	 * @param testDataKey
	 *            the test data key
	 * @return true, if successful
	 */
	public boolean hasTestData(TestDataKey testDataKey) {
		return tafTestData.containsKey(testDataKey);
	}

	/**
	 * Adds the data file.
	 * 
	 * @param fileKey
	 *            the file key
	 * @param filePath
	 *            the file path
	 * @return true, if successful
	 * @throws TafDataProviderException
	 *             the taf data provider exception
	 */
	public boolean addDataFile(String fileKey, String filePath) throws TafDataProviderException {
		if (null == fileKey || null == filePath) {
			return false;
		}

		// Create a file
		File dataFile = new File(filePath);

		// Check if it exists and the current user process can read
		if (!dataFile.exists() && !dataFile.canRead()) {
			throw new TafDataProviderException("Data File with Key=" + fileKey + " File Path = " + filePath + " does not exist");
		}

		// add it to the map
		return dataFilesInfo.put(fileKey, dataFile.getAbsolutePath()) != null;
	}

	public boolean isDataFileExists(String filePath) {

		boolean result = false;

		File dataFile = new File(filePath);
		if (dataFile.exists()) {
			result = true;
		}

		return result;

	}

	/**
	 * Gets the data file.
	 * 
	 * @param fileKey
	 *            the file key
	 * @return the data file
	 */
	public String getDataFile(String fileKey) {
		return dataFilesInfo.get(fileKey);
	}

	/**
	 * Checks for data file.
	 * 
	 * @param fileKey
	 *            the file key
	 * @return true, if successful
	 */
	public boolean hasDataFile(String fileKey) {
		return dataFilesInfo.containsKey(fileKey);
	}
}