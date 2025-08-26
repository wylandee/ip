package storage;

import task.*;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class Storage {
    private final Path filePath;

    public Storage(String filePath) {
        this.filePath = Paths.get(filePath);
        checkFileAndFolderExists();
    }

    private void checkFileAndFolderExists() {
        try {
            if (!Files.exists(filePath.getParent())) {
                Files.createDirectories(filePath.getParent());
            }
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.err.println("Eh you got an error creating the data file: " + e.getMessage());
        }
    }

    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                Task t = parseTask(line);
                if (t != null) {
                    tasks.add(t);
                }
            }
        } catch (IOException e) {
            System.err.println("Eh you got an error loading the tasks:" + e.getMessage());
        }
        return tasks;
    }

    private Task parseTask(String line) {
        String[] parts = line.split(" \\| ");
        String taskType = parts[0];
        boolean isDone = parts[1].equals("1");
        String desc = parts[2];

        Task task = null;
        switch (taskType) {
            case "T":
                task = new Todo(desc);
                break;
            case "D":
                task = new Deadline(desc, parts[3]);
                break;
            case "E":
                task = new Event(desc, parts[3], parts[4]);
                break;
        }
        if (task != null && isDone) {
            task.markAsDone();
        }
        return task;
    }

    public void save(TaskList tl) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toFile()))) {
            for (Task t : tl.getTasks()) {
                bw.write(formatTask(t));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    private String formatTask(Task t) {
        String status = t. isDone() ? "1" : "0";
        DateTimeFormatter saveFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

        if (t instanceof Todo) {
            return "T | " + status + " | " + t.getText();
        } else if (t instanceof Deadline) {
            Deadline d = (Deadline) t;
            return "D | " + status + " | " + d.getText() + " | " + d.getBy().format(saveFormat);
        } else if (t instanceof Event) {
            Event e = (Event) t;
            return "E | " + status + " | " + e.getText() + " | " + e.getFrom().format(saveFormat) + " | " + e.getTo().format(saveFormat);
        }
        return "";
    }
}
