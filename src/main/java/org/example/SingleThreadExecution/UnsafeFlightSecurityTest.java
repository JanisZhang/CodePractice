package org.example.SingleThreadExecution;

public class UnsafeFlightSecurityTest {

    static class Passenger extends Thread{
        private final String boardingpass ;
        private final String idcard ;

        private final UnsafeFlightSecurity unsafeFlightSecurity;

        public Passenger(UnsafeFlightSecurity unsafeFlightSecurity, String boardingpass, String idcard) {
            this.unsafeFlightSecurity = unsafeFlightSecurity;
            this.boardingpass = boardingpass;
            this.idcard = idcard;
        }

        @Override
        public void run() {
            while(true){
                unsafeFlightSecurity.pass(boardingpass,idcard);
            }
        }

        public static void main(String[] args) {
            final UnsafeFlightSecurity unsafeFlightSecurity = new UnsafeFlightSecurity();
            Passenger passenger1 = new Passenger(unsafeFlightSecurity,"aaa","aa");
            Passenger passenger2 = new Passenger(unsafeFlightSecurity,"bbb","bb");
            Passenger passenger3 = new Passenger(unsafeFlightSecurity,"ccc","cc");

            passenger1.start();
            passenger2.start();
            passenger3.start();
        }
    }
}
