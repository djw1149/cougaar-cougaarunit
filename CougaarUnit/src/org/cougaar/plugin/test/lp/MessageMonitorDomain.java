/*
 * <copyright>
 *  Copyright 1997-2001 BBNT Solutions, LLC
 *  under sponsorship of the Defense Advanced Research Projects Agency (DARPA).
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the Cougaar Open Source License as published by
 *  DARPA on the Cougaar Open Source Website (www.cougaar.org).
 *
 *  THE COUGAAR SOFTWARE AND ANY DERIVATIVE SUPPLIED BY LICENSOR IS
 *  PROVIDED 'AS IS' WITHOUT WARRANTIES OF ANY KIND, WHETHER EXPRESS OR
 *  IMPLIED, INCLUDING (BUT NOT LIMITED TO) ALL IMPLIED WARRANTIES OF
 *  MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE, AND WITHOUT
 *  ANY WARRANTIES AS TO NON-INFRINGEMENT.  IN NO EVENT SHALL COPYRIGHT
 *  HOLDER BE LIABLE FOR ANY DIRECT, SPECIAL, INDIRECT OR CONSEQUENTIAL
 *  DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE OF DATA OR PROFITS,
 *  TORTIOUS CONDUCT, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
 *  PERFORMANCE OF THE COUGAAR SOFTWARE.
 * </copyright>
 */

package org.cougaar.plugin.test.lp;

import java.util.*;
import org.cougaar.core.agent.ClusterServesLogicProvider;

import org.cougaar.core.blackboard.LogPlan;
import org.cougaar.core.blackboard.XPlanServesBlackboard;

import org.cougaar.core.component.BindingSite;

import org.cougaar.core.domain.DomainAdapter;
import org.cougaar.core.domain.DomainBindingSite;

import org.cougaar.glm.ldm.lps.*;

/**
 * COUGAAR Domain package definition.
 **/

public class MessageMonitorDomain extends DomainAdapter {
  public static final String NAME = "message_monitor".intern();

  public String getDomainName() {
    return NAME;
  }

  public MessageMonitorDomain() {
    super();

  }

  public void initialize() {
    super.initialize();
  }

  public void load() {
    super.load();
  }

  public Collection getAliases() {
    ArrayList l = new ArrayList(3);
    l.add("mm");
    return l;
  }

  protected void loadFactory() {
    setFactory(new MessageMonitorFactory());
  }

  protected void loadXPlan() {
    DomainBindingSite bindingSite = (DomainBindingSite) getBindingSite();

    if (bindingSite == null) {
      throw new RuntimeException("Binding site for the domain has not be set.\n" +
                             "Unable to initialize domain XPlan without a binding site.");
    }

    Collection xPlans = bindingSite.getXPlans();
    LogPlan logPlan = null;

    for (Iterator iterator = xPlans.iterator(); iterator.hasNext();) {
      XPlanServesBlackboard  xPlan = (XPlanServesBlackboard) iterator.next();
      if (xPlan instanceof LogPlan) {
        // Note that this means there are 2 paths to the plan.
        // Is this okay?
        logPlan = (LogPlan) logPlan;
        break;
      }
    }

    if (logPlan == null) {
      logPlan = new LogPlan();
    }

    setXPlan(logPlan);
  }

  protected void loadLPs() {
    DomainBindingSite bindingSite = (DomainBindingSite) getBindingSite();

    if (bindingSite == null) {
      throw new RuntimeException("Binding site for the domain has not be set.\n" +
                             "Unable to initialize domain LPs without a binding site.");
    }

    ClusterServesLogicProvider cluster = bindingSite.getClusterServesLogicProvider();
    LogPlan logPlan = (LogPlan) getXPlan();

    addLogicProvider(new MessageMonitorLP());
  }

}
