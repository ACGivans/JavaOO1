/**
   Name: Andrew Givans
   Date: 2/10/2016
  
            Description: Campaign DDC
            
      The purpose of this class is to allow for the creation of
    two separate campaign objects. The attributes are campaign name,
    wether or not the campaign is for profit, the goal amount for
    the donations to the campaign, and the total amount of donations
    for the campaign. There is a method which creates a string
    representation of each campaign object. There are setters that
    validate each attribute and getters which allow access to the
    private methods.
**/


public class Campaign{
   private String campaignName;
   private String forProfit;
   private double goalAmount;
   private double donationTotal;
   
   //Purpose: The purpose of this default constructor is to create a default object if it is created at a time when no parameters are available
   //Parameters: None
   //Return type: None
   public Campaign(){
   
   }
   
   //Purpose: The purpose of this specific constructor
   //Parameters: campaignName, forProfit, goalAmount, donationTotal
   //Return type: None
   public Campaign(String campaignName, String forProfit, double goalAmount, double donationTotal){
      this.campaignName = campaignName;
      this.forProfit = forProfit;
      this.goalAmount = goalAmount;
      this.donationTotal = donationTotal;
      
   }
   
   public String getCampaignName(){return campaignName;}
   public String getForProfit(){return forProfit;}
   public double getGoalAmount(){return goalAmount;}
   public double getDonationTotal(){return donationTotal;}
   
   //Purpose: The purpose of this method is to check if the campaignName entry is valid
   //Parameters: campaignName
   //Return type: void

   public void setCampaignName(String campaignName){
      this.campaignName = campaignName;
   }
   
   //Purpose: The purpose of this method is to check if the forProfit entry is valid
   //Parameters: forProfit
   //Return type: boolean

   public boolean setForProfit(String forProfit){
   
     if(forProfit != "yes" && forProfit != "no") { return false; }
     else {
     this.forProfit = forProfit;
     return true;
     }
   }
   
   //Purpose: The purpose of this method is to check if the goalAmount entry is valid
   //Parameters: goalAmount
   //Return type: void
   public boolean setGoalAmount(double goalAmount){
      
      if (goalAmount > 25000) return false;
      //else if (goalAmount = 0) {
      //this.goalAmount = 10000;
      //return true;
      //}
      else {
      this.goalAmount = goalAmount;
      return true; 
      }
   }
   
   //Purpose: The purpose of this method is to check if the donationTotal entry is valid
   //Parameters: donationTotal
   //Return type: void
   public void setDonationTotal(double donationTotal){
      //double administrativeFee = .05;
      //if (getForProfit() == "yes") { donationTotal = donationTotal - (donationTotal * administrativeFee);}
      //else { this.donationTotal = donationTotal;}
      this.donationTotal = donationTotal;
   }
   
   
   //Purpose: The purpose of this method is to create a specific toString for each campaign object
   //Parameters: None
   //Return type: String
   public String toString(){
   double overUnder = 0;
   if (goalAmount > getDonationTotal()){ overUnder = (getDonationTotal() - goalAmount); }
   if (goalAmount < getDonationTotal()){ overUnder = (goalAmount - getDonationTotal()); }
   if (goalAmount == getDonationTotal()) { overUnder = 0; }
   
   
   return
   "\nCampaign Name: " + getCampaignName() +
   "\nTotal Amount of donations: " + getDonationTotal() +
   "\nDonation Goal Amount: " + getGoalAmount() + 
   "\nOver/Under Amount: " + overUnder;
   }
   
}