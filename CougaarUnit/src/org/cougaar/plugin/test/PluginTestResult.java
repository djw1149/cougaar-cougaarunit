package org.cougaar.plugin.test;

import java.util.Vector;
import java.util.Enumeration;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class PluginTestResult {
    public static final int PHASE_TEST_SUBSCRIPTION = 1;
    public static final int PHASE_TEST_EXECUTION = 2;
    public static final int INITIAL_STATE = 0;
    public static final int COMMAND_SUBSCRIPTION_ASSERT = 1;
    public static final int COMMAND_ASSERT_PUBLISH_ADD = 2;
    public static final int COMMAND_ASSERT_PUBLISH_CHANGE = 3;
    public static final int COMMAND_ASSERT_PUBLISH_REMOVE = 4;

    static class TestResultEntry {
        int testPhase;
        int testCommand;
        boolean testResult;
        String description;
        int id =0;
        static int master_id=0;

        public TestResultEntry(int testPhase, int testCommand, boolean testResult, String description) {
            this.testPhase = testPhase;
            this.testCommand = testCommand;
            this.testResult = testResult;
            this.description = description;
            this.id = ++master_id;
        }
    }

    private static Vector entries = new Vector();
    private static String testName;
    private static String testDescription;


    public static void setTestName(String name) {
        testName = name;
    }

    public static void setTestDescription(String desc) {
        testDescription = desc;
    }

    public static void addEntry(int phase, int command, boolean result, String description) {
        entries.add(new TestResultEntry(phase, command, result, description));
    }

    /**
     * Returns the overall status if the test results
     * @return true if every test passed, false if at least one test failed
     */
    public static boolean getOverallResult() {
        for (Enumeration enum = entries.elements(); enum.hasMoreElements(); ) {
            if (!(((TestResultEntry)enum.nextElement()).testResult))
                return false;
        }
        return true;
    }

    private static String getPhaseAsString(int phaseId) {
        switch (phaseId) {
            case PHASE_TEST_SUBSCRIPTION: return "SUBSCRIPTION";
            case PHASE_TEST_EXECUTION: return "EXECUTION";
        }
        return "";
    }

    private static String getCommandAsString(int commandId) {
        switch (commandId) {
            case COMMAND_SUBSCRIPTION_ASSERT: return   "SUBSCRIPTION ASSERT";
            case COMMAND_ASSERT_PUBLISH_ADD: return    "PUBLISH ADD";
            case COMMAND_ASSERT_PUBLISH_CHANGE: return "PUBLISH CHANGE";
            case COMMAND_ASSERT_PUBLISH_REMOVE: return "PUBLISH REMOVE";
        }
        return "";
    }

    public static String getReportAsString() {
        StringBuffer result = new StringBuffer();
        result.append("Test Name: " + testName+"\n");
        for (Enumeration enum = entries.elements(); enum.hasMoreElements(); ) {
            TestResultEntry tre = (TestResultEntry)enum.nextElement();
            result.append("ID: " + String.valueOf(tre.id)+
                          "\nPhase: "+ getPhaseAsString(tre.testPhase)+
                          "\nCommand: "+getCommandAsString(tre.testCommand)+
                          "\nResult: "+String.valueOf(tre.testResult)+
                          "\nDescription: "+tre.description+"\n");
        }
        return result.toString();
    }

    public static String getReportAsXML() {
        StringBuffer result = new StringBuffer();
        result.append("<?xml version=\"1.0\"?>\n");
        result.append("<TEST Name=\""+testName+"\">\n");
        for (Enumeration enum = entries.elements(); enum.hasMoreElements(); ) {
            TestResultEntry tre = (TestResultEntry)enum.nextElement();
            result.append("<ID Value=\""+ String.valueOf(tre.id)+"\">\n");
            result.append("<PHASE>" + getPhaseAsString(tre.testPhase) + "</PHASE>\n");
            result.append("<COMMAND>" +getCommandAsString(tre.testCommand)+"</COMMAND>\n");
            result.append("<DESCRIPTION>"+tre.description+"</DESCRIPTION>\n");
            result.append("<RESULT>" + String.valueOf(tre.testResult) + "</RESULT>\n");
            result.append("</ID>\n");
        }
        result.append("</TEST>");
        return result.toString();
    }
}