/*
 * <copyright>
 *  Copyright 1997-2003 BBNT Solutions, LLC
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

/* @generated Thu May 22 12:07:07 EDT 2003 from programmer_assets.def - DO NOT HAND EDIT */
package tutorial.assets;
import org.cougaar.planning.ldm.asset.*;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Vector;
import java.beans.PropertyDescriptor;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
/** Representation of a programmer with languages and skills represented **/

public class ProgrammerAsset extends tutorial.ProgrammerAssetAdapter {

  public ProgrammerAsset() {
    myLanguagePG = null;
    mySkillsPG = null;
  }

  public ProgrammerAsset(ProgrammerAsset prototype) {
    super(prototype);
    myLanguagePG=null;
    mySkillsPG=null;
  }

  /** For infrastructure only - use org.cougaar.core.domain.Factory.copyInstance instead. **/
  public Object clone() throws CloneNotSupportedException {
    ProgrammerAsset _thing = (ProgrammerAsset) super.clone();
    if (myLanguagePG!=null) _thing.setLanguagePG(myLanguagePG.lock());
    if (mySkillsPG!=null) _thing.setSkillsPG(mySkillsPG.lock());
    return _thing;
  }

  /** create an instance of the right class for copy operations **/
  public Asset instanceForCopy() {
    return new ProgrammerAsset();
  }

  /** create an instance of this prototype **/
  public Asset createInstance() {
    return new ProgrammerAsset(this);
  }

  protected void fillAllPropertyGroups(Vector v) {
    super.fillAllPropertyGroups(v);
    { Object _tmp = getLanguagePG();
    if (_tmp != null && !(_tmp instanceof Null_PG)) {
      v.addElement(_tmp);
    } }
    { Object _tmp = getSkillsPG();
    if (_tmp != null && !(_tmp instanceof Null_PG)) {
      v.addElement(_tmp);
    } }
  }

  private transient LanguagePG myLanguagePG;

  public LanguagePG getLanguagePG() {
    LanguagePG _tmp = (myLanguagePG != null) ?
      myLanguagePG : (LanguagePG)resolvePG(LanguagePG.class);
    return (_tmp == LanguagePG.nullPG)?null:_tmp;
  }
  public void setLanguagePG(PropertyGroup arg_LanguagePG) {
    if (!(arg_LanguagePG instanceof LanguagePG))
      throw new IllegalArgumentException("setLanguagePG requires a LanguagePG argument.");
    myLanguagePG = (LanguagePG) arg_LanguagePG;
  }

  private transient SkillsPG mySkillsPG;

  public SkillsPG getSkillsPG() {
    SkillsPG _tmp = (mySkillsPG != null) ?
      mySkillsPG : (SkillsPG)resolvePG(SkillsPG.class);
    return (_tmp == SkillsPG.nullPG)?null:_tmp;
  }
  public void setSkillsPG(PropertyGroup arg_SkillsPG) {
    if (!(arg_SkillsPG instanceof SkillsPG))
      throw new IllegalArgumentException("setSkillsPG requires a SkillsPG argument.");
    mySkillsPG = (SkillsPG) arg_SkillsPG;
  }

  // generic search methods
  public PropertyGroup getLocalPG(Class c, long t) {
    if (LanguagePG.class.equals(c)) {
      return (myLanguagePG==LanguagePG.nullPG)?null:myLanguagePG;
    }
    if (SkillsPG.class.equals(c)) {
      return (mySkillsPG==SkillsPG.nullPG)?null:mySkillsPG;
    }
    return super.getLocalPG(c,t);
  }

  public PropertyGroupSchedule getLocalPGSchedule(Class c) {
    return super.getLocalPGSchedule(c);
  }

  public void setLocalPG(Class c, PropertyGroup pg) {
    if (LanguagePG.class.equals(c)) {
      myLanguagePG=(LanguagePG)pg;
    } else
    if (SkillsPG.class.equals(c)) {
      mySkillsPG=(SkillsPG)pg;
    } else
      super.setLocalPG(c,pg);
  }

  public void setLocalPGSchedule(PropertyGroupSchedule pgSchedule) {
      super.setLocalPGSchedule(pgSchedule);
  }

  public PropertyGroup removeLocalPG(Class c) {
    PropertyGroup removed = null;
    if (LanguagePG.class.equals(c)) {
      removed=myLanguagePG;
      myLanguagePG=null;
    } else
    if (SkillsPG.class.equals(c)) {
      removed=mySkillsPG;
      mySkillsPG=null;
    } else
      removed=super.removeLocalPG(c);
    return removed;
  }

  public PropertyGroup removeLocalPG(PropertyGroup pg) {
    PropertyGroup removed = null;
    Class pgc = pg.getPrimaryClass();
    if (LanguagePG.class.equals(pgc)) {
      removed=myLanguagePG;
      myLanguagePG=null;
    } else
    if (SkillsPG.class.equals(pgc)) {
      removed=mySkillsPG;
      mySkillsPG=null;
    } else
      removed= super.removeLocalPG(pg);
    return removed;
  }

  public PropertyGroupSchedule removeLocalPGSchedule(Class c) {
    PropertyGroupSchedule removed = null;
    return removed;
  }

  public PropertyGroup generateDefaultPG(Class c) {
    if (LanguagePG.class.equals(c)) {
      return (myLanguagePG= new LanguagePGImpl());
    } else
    if (SkillsPG.class.equals(c)) {
      return (mySkillsPG= new SkillsPGImpl());
    } else
      return super.generateDefaultPG(c);
  }

  // dumb serialization methods

  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
      if (myLanguagePG instanceof Null_PG || myLanguagePG instanceof Future_PG) {
        out.writeObject(null);
      } else {
        out.writeObject(myLanguagePG);
      }
      if (mySkillsPG instanceof Null_PG || mySkillsPG instanceof Future_PG) {
        out.writeObject(null);
      } else {
        out.writeObject(mySkillsPG);
      }
  }

  private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
    in.defaultReadObject();
      myLanguagePG=(LanguagePG)in.readObject();
      mySkillsPG=(SkillsPG)in.readObject();
  }
  // beaninfo support
  private static PropertyDescriptor properties[];
  static {
    try {
      properties = new PropertyDescriptor[2];
      properties[0] = new PropertyDescriptor("LanguagePG", ProgrammerAsset.class, "getLanguagePG", null);
      properties[1] = new PropertyDescriptor("SkillsPG", ProgrammerAsset.class, "getSkillsPG", null);
    } catch (IntrospectionException ie) {}
  }

  public PropertyDescriptor[] getPropertyDescriptors() {
    PropertyDescriptor[] pds = super.getPropertyDescriptors();
    PropertyDescriptor[] ps = new PropertyDescriptor[pds.length+2];
    System.arraycopy(pds, 0, ps, 0, pds.length);
    System.arraycopy(properties, 0, ps, pds.length, 2);
    return ps;
  }
}
