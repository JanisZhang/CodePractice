package org.example.SingleThreadExecution;

public class UnsafeFlightSecurity {

    private  int count =0;
    private String boardingpass = "null";
    private String idcard = "null";

//    public void pass(String boardingpass, String idcard){
//        this.boardingpass = boardingpass;
//        this.idcard = idcard;
//
//        count++;
//        check();
//    }

    public synchronized void pass(String boardingpass, String idcard){
        this.boardingpass = boardingpass;
        this.idcard = idcard;

        count++;
        check();
    }

    private void check() {
        if(boardingpass.charAt(0)!=idcard.charAt(0)){
            try {
                throw new Exception("====Exception====" + toString1());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString1() {
        return "The "+ count+"passengers, boardingpass [ "+boardingpass+" ] , idcard [ "+idcard+"]";
    }
}
