package model.store;

public class storeVO {
   
   private int snum;
   private String sname;
   private String scall;
   private int mnum;
   public int getMnum() {
      return mnum;
   }
   public void setMnum(int mnum) {
      this.mnum = mnum;
   }
   public int getSnum() {
      return snum;
   }
   public void setSnum(int snum) {
      this.snum = snum;
   }
   public String getSname() {
      return sname;
   }
   public void setSname(String sname) {
      this.sname = sname;
   }
   public String getScall() {
      return scall;
   }
   public void setScall(String scall) {
      this.scall = scall;
   }
   @Override
   public String toString() {
      return "storeVO [snum=" + snum + ", sname=" + sname + ", scall=" + scall + ", mnum=" + mnum + "]";
   }
   
   

}