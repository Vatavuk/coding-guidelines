package hr.com.vgv.examples.fakes;

public interface Alarms
{
    void raiseAlarm(String message);

    class Fake implements Alarms {

        private String msg;

        @Override
        public void raiseAlarm(String message)
        {
            this.msg = message;
        }

        public String errorMessage() {
            return msg;
        }

        public boolean isRaised() {
            return errorMessage() != null;
        }
    }
}
