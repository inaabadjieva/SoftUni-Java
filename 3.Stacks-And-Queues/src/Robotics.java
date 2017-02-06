import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsLine = scanner.nextLine().split(";");

        //read robots
        ArrayList<Robot> robots = new ArrayList<>();
        addRobots(robotsLine, robots);

        //read start time
        String[] startTime = scanner.nextLine().split(":");
        long startSeconds = Long.parseLong(startTime[0]) * 60 * 60 +
                            Long.parseLong(startTime[1]) * 60 +
                            Long.parseLong(startTime[2]);

        //read products
        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.add(product);
            product = scanner.nextLine();
        }

        //loop through products
        while (!products.isEmpty()) {
            startSeconds++;
            String currentProduct = products.poll();
            boolean productIsProcessed = false;

            for (Robot robot : robots) {
                //update robots time if busy

                if (robot.isBusy()) {
                    long timeLeft = robot.getTimeCurrentProduct() - 1;
                    robot.setTimeCurrentProduct(timeLeft);
                    if (robot.getTimeCurrentProduct() <= 0) {
                        robot.setIsBusy(false);
                        robot.setTimeCurrentProduct(null);
                    }
                }

                if (productIsProcessed){
                    continue;
                }

                if (!robot.isBusy()) {
                    robot.setIsBusy(true);
                    robot.setTimeCurrentProduct(robot.getProcessingTime());
                    productIsProcessed = true;

                    String currentTime = getCurrentTime(startSeconds);

                    System.out.printf("%s - %s %s", robot.getName(), currentProduct, currentTime);
                }
            }
            if (!productIsProcessed) {
                products.add(currentProduct);
            }
        }
    }

    private static void addRobots(String[] robotsLine, ArrayList<Robot> robots) {
        for (int i = 0; i < robotsLine.length; i++) {
            String[] robotInfo = robotsLine[i].split("-");
            String name = robotInfo[0];
            long processingTime = Long.parseLong(robotInfo[1]);

            Robot robot = new Robot(name, processingTime);
            robots.add(robot);
        }
    }

    private static String getCurrentTime(long currentSeconds) {
        long hours = ((int) (currentSeconds / 3600)) % 24;
        long remainder = currentSeconds % 3600;
        long minutes = remainder / 60;
        long seconds = remainder % 60;

        String currentTime = String.format("[%02d:%02d:%02d]%n", hours, minutes, seconds);

        return currentTime;
    }

    public static class Robot {
        String name;
        long processingTime;
        boolean processingProduct;
        Long timeCurrentProduct;

        public Robot(String name, long processingTime) {
            this.name = name;
            this.processingTime = processingTime;
            this.processingProduct = false;
            this.timeCurrentProduct = null;
        }

        public String getName() {
            return name;
        }

        public long getProcessingTime() {
            return processingTime;
        }

        public boolean isBusy() {
            return processingProduct;
        }

        public void setIsBusy(boolean processingProduct) {
            this.processingProduct = processingProduct;
        }

        public Long getTimeCurrentProduct() {
            return timeCurrentProduct;
        }

        public void setTimeCurrentProduct(Long timeCurrentProduct) {
            this.timeCurrentProduct = timeCurrentProduct;
        }
    }
}