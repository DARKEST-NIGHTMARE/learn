////import java.io.FileNotFoundException;
////import java.io.FileReader;
////import java.io.BufferedReader;
////import java.io.IOException;
////
////public class jsonRead{
////    public static void main(String[] args) throws IOException {
////        String filePath = "/home/manmathp@id.argusoft.com/IdeaProjects/practice/Game.json";
////        String Line = null;
////
//////        try {
//////            FileReader br = new FileReader(String.valueOf(new FileReader(filePath)));
//////
//////            while (Line != null) {
//////                System.out.println(Line);
//////
//////                Line = String.valueOf(br.read());
//////            }
//////        }
//////        catch (IOException e) {
//////
//////            System.err.println(e.getMessage());
//////            e.printStackTrace();
//////        }
//////
//////
//////
//////        }
////
////    }
////
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//public class jsonRead {
//
//    public static void main(String[] args) {
//        String filePath = "Game.json";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder jsonContent = new StringBuilder();
//            String line;
//            while ((line = br.readLine()) != null) {
//                jsonContent.append(line);
//
//            }
//            String rawJsonString = jsonContent.toString();
//            System.out.println("Raw JSON content read from file:");
//            System.out.println("\n"+rawJsonString);
//
//            List<Game> games = parseGameArray(rawJsonString);
//
//            System.out.println("\nExtracted Game Data:");
//            for (Game game : games) {
//                System.out.println("Name: " + game.name + ", Rating: " + game.rating + ", Year: " + game.year);
//            }
//
//        } catch (IOException e) {
//            System.err.println("Error reading the JSON file: " + e.getMessage());
//        }
//    }
//
//
//    private static List<Game> parseGameArray(String jsonArrayString) {
//        List<Game> games = new ArrayList<>();
//        String content = jsonArrayString.substring(1, jsonArrayString.length() - 1);
//        String[] gameStrings = content.split("},\\{");
//
//        for (String gameString : gameStrings) {
//            Game game = new Game();
//
//            String cleanString = gameString.replace("\"", "").replace("{", "").replace("}", "");
//            String[] properties = cleanString.split(",");
//
//            for (String property : properties) {
//                String[] keyValue = property.split(":");
//                if (keyValue.length == 2) {
//                    String key = keyValue[0].trim();
//                    String value = keyValue[1].trim();
//
//                    if (key.equalsIgnoreCase("name")) {
//                        game.name = value;
//                    } else if (key.equalsIgnoreCase("rating")) {
//                        try {
//                            game.rating = Double.parseDouble(value);
//                        } catch (NumberFormatException e) {
//                            System.err.println("Error parsing rating: " + value);
//                        }
//                    } else if (key.equalsIgnoreCase("year")) {
//                        try {
//                            game.year = Integer.parseInt(value);
//                        } catch (NumberFormatException e) {
//                            System.err.println("Error parsing year: " + value);
//                        }
//                    }
//                }
//            }
//            games.add(game);
//        }
//        return games;
//    }
//
//
//    static class Game {
//        public String name;
//        public double rating;
//        public int year;
//    }
//}





import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class jsonRead {

    public static void main(String[] args) {
        String filePath = "Game.json";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
            String rawJsonString = jsonContent.toString();
            System.out.println("Raw JSON content read from file:");
            System.out.println("\n" + rawJsonString);
            Map<String, Game> games = parseGameArray(rawJsonString);

            System.out.println("\nExtracted Game Data:");
            for (Map.Entry<String, Game> entry : games.entrySet()) {
                String name = entry.getKey();
                Game game = entry.getValue();
                System.out.println("Name: " + name + ", Rating: " + game.rating + ", Year: " + game.year);
            }

        } catch (IOException e) {
            System.err.println("Error reading the JSON file: " + e.getMessage());
        }
    }


    private static Map<String, Game> parseGameArray(String jsonArrayString) {
        Map<String, Game> games = new HashMap<>();
        String content = jsonArrayString.substring(1, jsonArrayString.length() - 1);
        String[] gameStrings = content.split("\\},\\s*\\{");

        for (String gameString : gameStrings) {
            Game game = new Game();

            String cleanString = gameString.replace("\"", "").replace("{", "").replace("}", "");
            String[] properties = cleanString.split(",");

            String gameName = null;

            for (String property : properties) {
                String[] keyValue = property.split(":");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    if (key.equalsIgnoreCase("name")) {
                        game.name = value;
                        gameName = value;
                    } else if (key.equalsIgnoreCase("rating")) {
                        try {
                            game.rating = Double.parseDouble(value);
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing rating: " + value);
                        }
                    } else if (key.equalsIgnoreCase("year")) {
                        try {
                            game.year = Integer.parseInt(value);
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing year: " + value);
                        }
                    }
                }
            }
            if (gameName != null) {
                games.put(gameName, game);
            } else {
                System.err.println("Error: Game object without a 'name' property was skipped.");
            }
        }
        return games;
    }


    static class Game {
        public String name;
        public double rating;
        public int year;
    }
}
