/**
   Name: Andrew Givans
   Date: 2/10/2016
  
            Description: Campaigns Implementation class
            
      The purpose of this class is to first create a campaign
   with predetermined attributes. Then, it gives the user the 
   ability to create a campaign with custom credentials. After
   the user is done entering the custom credentials, the program
   prints a report containing the values for both campaigns. 
   
**/

import javax.swing.JOptionPane;
public class Campaigns {
	public static void main (String [] args){
    	String campaignList = "";
      String highestDonation = "";

      Campaign aCampaign = new Campaign("IT Student Scholarship Fund", "Yes", 15000, 6855);
      
      campaignList+= aCampaign.toString();
      
      Campaign aCampaign2 = addCampaign();
      
      campaignList+= aCampaign2.toString();
      
      if (aCampaign.getDonationTotal() > aCampaign2.getDonationTotal()) {highestDonation = aCampaign.getCampaignName();}
      else if (aCampaign2.getDonationTotal() > aCampaign.getDonationTotal()) {highestDonation = aCampaign2.getCampaignName();}
      else if (aCampaign2.getDonationTotal() == aCampaign.getDonationTotal()) {highestDonation = "Both campaigns collected the same amount";}
      
      printReport(campaignList, highestDonation);
      
   }

   //Purpose: The purpose of this method is to allow the user to enter the credentials for a campaign object and create that campaign object
   //Parameters: None
   //Return type: Campaign

   private static Campaign addCampaign(){
      final int DONATION_MAX = 25000;

      Campaign campaign2 = new Campaign();
      
      
      campaign2.setCampaignName(JOptionPane.showInputDialog("Enter the name of the campaign: "));
      campaign2.setForProfit(JOptionPane.showInputDialog("Is the campaign for profit?"));
           campaign2.setGoalAmount(Double.parseDouble(JOptionPane.showInputDialog("What is the goal donation amount?")));
      double donationTotal = 0;
      
      do{
      double donation = Double.parseDouble(JOptionPane.showInputDialog("What is the donation amount?"));
      donation += donationTotal;
      }while (JOptionPane.showConfirmDialog(null, "Would you like to enter another donation?")== JOptionPane.YES_OPTION && donationTotal < DONATION_MAX);
      
      double administrativeFee = .05;
      if (campaign2.getForProfit() == "yes") { donationTotal = donationTotal - (donationTotal * administrativeFee);}
      else {donationTotal = donationTotal;}
      
      return campaign2;
   }
   
   //Purpose: The purpose of this method is to print a report containing the details for each campaign
   //Parameters: campaignList, highestDonation
   //Return type: void
   private static void printReport(String campaignList, String highestDonation){
            
      
      JOptionPane.showMessageDialog(null, "Campaign Overview:\n" + campaignList.toString() +
      "\nHighest Donation Amount: " + highestDonation);
  
   }

}
