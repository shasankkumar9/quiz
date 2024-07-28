//package quiz_bkp.complex;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class RecroAssessment {
//
//    public static void main(String[] args) {
//        String[] lines = getLines();
//        List<CallLog> callLogs = Arrays.stream(lines).map(line -> {
//            String[] logDetails = line.split(" ");
//            return new CallLog(Integer.parseInt(logDetails[0]), logDetails[1], Integer.parseInt(logDetails[2]));
//        }).collect(Collectors.toList());
//
//        List<Integer> flaggedDays = getFlaggedDays(callLogs, 1, 10);
//        System.out.println("flaggedDays = " + flaggedDays);
//    }
//
//    private static List<Integer> getFlaggedDays(List<CallLog> callLogs, int startDay, int endDay) {
//
//        int duplicateCount = 0;
//        String prevPhoneNumber = callLogs.getFirst().phoneNumber;
//
//        List<Integer> flaggedDays = new ArrayList<Integer>();
//
//        for (int i = 0; i < callLogs.size(); i++) {
//
//            if (callLogs.get(i).phoneNumber.equals(prevPhoneNumber)) {
//                ++duplicateCount;
//            } else {
//                duplicateCount = 0;
//            }
//
//            if (duplicateCount >= 3) {
//                if (duplicateCount == 3)
//                    flaggedDays.add(callLogs.get(i - 1).day);
//                flaggedDays.add(callLogs.get(i).day);
//            }
//
//        }
//
//        return flaggedDays;
//
//    }
//
//    private static String[] getLines() {
//        String logs = "1122444111 18005672222 1\n" +
//                "1122444111 18005672222 2\n" +
//                "1122444111 18005672222 4\n" +
//                "1122444111 18005673333 5\n" +
//                "1122444111 18005675555 6\n" +
//                "1122444111 18005676666 7\n" +
//                "1122444222 18005677777 8\n" +
//                "1122444222 18005678888 9\n" +
//                "1122444111 18005679999 9\n" +
//                "1122444111 18005670000 10";
//
//        String[] lines = logs.split("\n");
//        return lines;
//    }
//
//    static record CallLog(
//            int callerId,
//            String phoneNumber,
//            int day
//    ) {
//    }
//
//}
