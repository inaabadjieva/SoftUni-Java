import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ParkingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> steps = new ArrayList<>();
        String[] input = reader.readLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[] matrixDimensions = {rows, cols};

        HashMap<Integer, HashSet<Integer>> matrix = new HashMap<>();
        for (int i = 0; i < matrixDimensions[0]; i++) {
            matrix.put(i, new HashSet<>());
        }

        String line = reader.readLine();
        while(!"stop".equals(line)){
            String[] indexes = line.split(" ");
            Integer enteringRow = Integer.parseInt(indexes[0]);
            Integer desiredRow = Integer.parseInt(indexes[1]);
            Integer desiredCol = Integer.parseInt(indexes[2]);

            Boolean hasParked = false;

            Integer initialSteps = 1 + Math.abs(desiredRow - enteringRow) + desiredCol;
            Integer currentSteps = initialSteps;
            Integer finalCol = -1;

            if(matrix.get(desiredRow).contains(desiredCol)){
                for (int i = desiredCol - 1; i >= 1; i--) {
                    if(!matrix.get(desiredRow).contains(i)){
                        finalCol = i;
                        currentSteps = initialSteps - (desiredCol - i);
                        hasParked = true;
                        break;
                    }
                }

                if(hasParked){
                    int distanceTraversed = desiredCol + (desiredCol - finalCol);
                    if(distanceTraversed >= matrixDimensions[1]){
                        distanceTraversed = matrixDimensions[1];
                    }
                    for (int i = desiredCol + 1; i < distanceTraversed; i++) {
                        if(!matrix.get(desiredRow).contains(i)){
                            finalCol = i;
                            currentSteps = initialSteps + (i - desiredCol);
                            break;
                        }
                    }
                } else {
                    for (int i = desiredCol + 1; i < matrixDimensions[1]; i++) {
                        if(!matrix.get(desiredRow).contains(i)){
                            finalCol = i;
                            currentSteps = initialSteps + (i - desiredCol);
                            hasParked = true;
                            break;
                        }
                    }
                }
            } else {
                finalCol = desiredCol;
                hasParked = true;
            }

            if(hasParked){
                matrix.get(desiredRow).add(finalCol);
                steps.add(currentSteps.toString());
            } else {
                steps.add(String.format("Row %s full", desiredRow));
            }

            line = reader.readLine();
        }

        System.out.println(String.join("\n", steps));
    }
}
