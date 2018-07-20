package com.plivo.reporting;
//package com.thoughtworks.reporting;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.io.PrintStream;
//import org.testng.annotations.AfterSuite;
//
//import com.thoughtworks.variables.Var;
//
//public class Report{
//
//	@AfterSuite
//	public static void generateReport() {
//
//     try {
//    	 
//    	 ExtractResult.execute();
//    	 
//         //   BufferedReader txtfile = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\TestReport\\2013-12-03_17-04-24.txt"));
//            OutputStream htmlfile= new FileOutputStream(new File(System.getProperty("user.dir")+"/Report/ThoughtWorks Web Test Automation suite "+Var.genericName+".html"));
//            PrintStream printhtml = new PrintStream(htmlfile);
//            String[] test = new String[500];
//            String[] txtbyLine = new String[500];
//            Object[] keys = new String[500];
//            Object[] values = new String[500];
//            String temp = "";
//            String mapData = "";
//            String color = "";
//            //String bgImage = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").lastIndexOf("\\"))+"\\Optymation"+"\\Image\\OptymTree.png";
//           
//            //Setting the table headers
//            String htmlheader="<html><head>";
//            htmlheader+="<title>Equivalent HTML</title>";
//            htmlheader+="</head><body bgcolor=\"#333333\" >";
//            String htmlfooter="</body></html>";
//            int linenum = 0 ;
//            
//            //Setting the table properties
//            printhtml.println("<TABLE BORDER=\"5\"    WIDTH=\"50%\"   CELLPADDING=\"4\" CELLSPACING=\"3\" align=\"center\">");
//            printhtml.println("<TR>");
//            printhtml.println("<TH BGCOLOR=\"#CC0000\" COLSPAN=\"2\"><BR><H3> Web Test Automation Report</H3>");
//            printhtml.println("</TH>");
//            printhtml.println("</TR>");
//            printhtml.println("<TR>");
//            printhtml.println("<TH BGCOLOR=\"#969799\">TEST CASE</TH>");
//            printhtml.println("<TH BGCOLOR=\"#969799\">RESULT</TH>");
//            printhtml.println("</TR>");
//                       
//            if(Var.resultMap.size() != 0){
//            	 keys = Var.resultMap.keySet().toArray();
//                 values = Var.resultMap.values().toArray();
//            }
//
//            for(int i=0;i<keys.length;i++)
//                {
//                    if(i == 0)
//                    {
//                        temp = htmlheader + keys[0];
//                        keys[0] = temp;
//                    }
//                    if(linenum == i+1)
//                    {
//                        temp = keys[i] + htmlfooter;
//                        keys[i] = temp;
//                    }    
//                    
//            //If passed, add an entry an mark the text in green          
//            if(values[i].equals("PASSED")){
//            	
//            	 printhtml.println("<TR ALIGN=\"CENTER\" bgcolor=\"white\">");
//                 printhtml.println("<TD bgcolor=\"#E6E6E6\", style=\"font-weight:bold\">"+keys[i]+"</TD>");
//                 
//                 color = "#5CE62E";
//                 
//                 printhtml.println("<TD bgcolor=\""+color+"\", style=\"font-weight:bold\">"+values[i]+"</TD>");
//                 printhtml.println("</TR>");
//            	
//            }
//            
//            //If failed, add an entry an mark the text in red
//            if(values[i].equals("FAILED")){
//            	
//            	printhtml.println("<TR ALIGN=\"CENTER\" bgcolor=\"white\">");
//            	printhtml.println("<TD bgcolor=\"#E6E6E6\", style=\"font-weight:bold\">"+keys[i]+"</TD>");
//                
//                color = "red";
//                
//                printhtml.println("<TD bgcolor=\""+color+"\", style=\"font-weight:bold\">"+values[i]+"</TD>");
//                printhtml.println("</TR>");
//           	
//           }
//            
//          //If not passed or failed, add an entry an mark the text in yellow
//            if(!(values[i].equals("PASSED") || values[i].equals("FAILED"))){
//            	
//              	 printhtml.println("<TR ALIGN=\"CENTER\" bgcolor=\"white\">");
//              	 printhtml.println("<TD bgcolor=\"#E6E6E6\">"+keys[i]+"</TD>");
//                   
//                 color = "#F4FA58";
//                   
//                 printhtml.println("<TD bgcolor=\""+color+"\">"+values[i]+"</TD>");
//                 printhtml.println("</TR>");
//              	
//              }                       
//            
//           }                    
//            
//            printhtml.println("</TABLE>");
//            
//        printhtml.close();
//        htmlfile.close();
//
//    }
//
//    catch (Exception e) {
//    	System.out.println(e);
//    }
//}
//
//	
//}