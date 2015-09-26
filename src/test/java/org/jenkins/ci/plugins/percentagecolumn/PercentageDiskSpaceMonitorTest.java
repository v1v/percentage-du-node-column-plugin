package org.jenkins.ci.plugins.percentagecolumn;

import hudson.slaves.DumbSlave;
import hudson.slaves.SlaveComputer;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Victor Martinez
 */
public class PercentageDiskSpaceMonitorTest {

    @Rule
    public JenkinsRule j = new JenkinsRule();

    @Test
    public void percentageDiskSpace() throws Exception {
        DumbSlave s = j.createSlave();
        SlaveComputer c = s.getComputer();
        c.connect(false).get(); // wait until it's connected
        if(c.isOffline())
            fail("Slave failed to go online: " + c.getLog());
        assertTrue(c.getMonitorData().containsKey(org.jenkins.ci.plugins.percentagecolumn.PercentageDiskSpaceMonitor.class.getCanonicalName()));
    }
}