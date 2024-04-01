import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class NoteBook {
    private String model; // модель
    private String color; // цвет
    private int ram; // оперативка
    private String processor; // процессор
    private String videocard; // видюха
    private String oc; // операционка

    public NoteBook(String model) {
        super(); // вызываем конструктор родителя, можно не делать, но по привычке я это пишу
        this.model = model;
        color = "Unknown";
        ram = -1;
        videocard = "Unknown";
        processor = "Unknown";
        oc = "Unknown";

    }

    public NoteBook(String model, String color, int ram, String processor, String videocard, String oc) {
        super(); // вызываем конструктор родителя, можно не делать, но по привычке я это пишу
        this.model = model;
        this.color = color;
        this.ram = ram;
        this.videocard = videocard;
        this.processor = processor;
        this.oc = oc;
    }

    public void setModel(String value) {
        this.model = value;
    }

    public String getModel() {
        return this.model;
    }

    public void setColor(String value) {
        this.color = value;
    }

    public String getColor() {
        return this.color;
    }

    public void setRam(int value) {
        this.ram = value;
    }

    public int getRam() {
        return this.ram;
    }

    public void setProcessor(String value) {
        this.processor = value;
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setVideocard(String value) {
        this.videocard = value;
    }

    public String getVideocard() {
        return this.videocard;
    }

    public void setOc(String value) {
        this.oc = value;
    }

    public String getOc() {
        return this.oc;
    }

    @Override
    public String toString() {
        String s = "";
        s = "Модель: " + model + "\n";
        s = s + "     Цвет: " + color + "\n";
        s = s + "     ОЗУ: " + Integer.toString(ram) + "\n";
        s = s + "     Процессор: " + processor + "\n";
        s = s + "     Видеокарта: " + videocard + "\n";
        s = s + "     Операционная система: " + oc + "\n";

        return s;

    }
}

// Не удаляйте и не меняйте метод Main!
public class Main {

    public static List<NoteBook> lNoteBook = new LinkedList<NoteBook>();

    private static NoteBook findNoteBook(String model) {
        for (NoteBook item : lNoteBook) {
            if (item.getModel().equals(model)) {
                return item;

            }
        }

        return null;
    }

    public static void addNoteBook() {
        Scanner scn = new Scanner(System.in);

        String model;
        String color;
        int ram;
        String processor;
        String videocard;
        String oc;

        System.out.println("[ДОБАВЛЕНИЕ НОУТБУКА]");

        System.out.println(" >>> Введите модель:");
        model = scn.nextLine();

        System.out.println(" >>> Введите цвет:");
        color = scn.nextLine();

        System.out.println(" >>> Введите модель процессора:");
        processor = scn.nextLine();

        System.out.println(" >>> Введите модель видеокарты:");
        videocard = scn.nextLine();

        System.out.println(" >>> Введите операционную систему:");
        oc = scn.nextLine();

        System.out.println(" >>> Введите объем ОЗУ:");
        ram = scn.nextInt();

        if (findNoteBook(model) != null) {
            System.out.println("Ноутбук с такой моделью уже существует!");
        } else {
            NoteBook notebook = new NoteBook(model, color, ram, processor, videocard, oc);
            lNoteBook.add(notebook);
        }

    }

    public static void editNoteBook() {
        System.out.println("[ИЗМЕНЕНИЕ НОУТБУКА]");
        System.out.println(" Введите модель ноутбука:");
        Scanner scn = new Scanner(System.in);

        String model = scn.nextLine();
        String color;
        int ram;
        String processor;
        String videocard;
        String oc;

        NoteBook notebook = findNoteBook(model);

        if (notebook == null) {
            System.out.println("Ноутбук с такой моделью не найден!");
        } else {
            System.out.println(" >>> Введите цвет (если не нужно редактировать данный параметр поставьте символ -):");
            color = scn.nextLine();
            if (!color.equals("-"))
                notebook.setColor(color);

            System.out.println(
                    " >>> Введите модель процессора (если не нужно редактировать данный параметр поставьте символ -):");
            processor = scn.nextLine();
            if (!processor.equals("-"))
                notebook.setProcessor(processor);

            System.out.println(
                    " >>> Введите модель видеокарты (если не нужно редактировать данный параметр поставьте символ -):");
            videocard = scn.nextLine();
            if (!videocard.equals("-"))
                notebook.setVideocard(videocard);

            System.out.println(
                    " >>> Введите операционную систему (если не нужно редактировать данный параметр поставьте символ -):");
            oc = scn.nextLine();
            if (!oc.equals("-"))
                notebook.setOc(oc);

            System.out.println(" >>> Введите объем ОЗУ (если не нужно редактировать данный параметр введите -1):");
            ram = scn.nextInt();
            if (ram != -1)
                notebook.setRam(ram);

        }

    }

    public static void deleteNoteBook() {
        System.out.println("[УДАЛЕНИЕ НОУТБУКА]");
        System.out.println(" Введите модель ноутбука:");
        Scanner scn = new Scanner(System.in);

        String model = scn.nextLine();

        NoteBook notebook = findNoteBook(model);

        if (notebook == null) {
            System.out.println("Ноутбук с такой моделью не найден!");
            return;
        }

        lNoteBook.remove(notebook);

        /*
         * for (int i =lNoteBook.size()-1); i<=0; i--) {
         * if (notebook = lNoteBook.get(i)) lNoteBook.remove(i);
         * }
         */
    }

    public static void printNotebook() {
        System.out.println("[СПИСОК НОУТБУКОВ]");

        for (NoteBook item : lNoteBook) {
            System.out.println(item.toString() + "\n");

        }
    }

    public static void setFilter() {

        String model = "";
        String color = "";
        int ram = -1;
        String processor = "";
        String videocard = "";
        String oc = "";

        Scanner scn = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);

        System.out.println("[ФИЛЬТР ДАННЫХ]");
        System.out.println(" Выберете критерий фильтра:");
        System.out.println("  >>0. Модель");
        System.out.println("  >>1. Цвет");
        System.out.println("  >>2. ОЗУ");
        System.out.println("  >>3. Процессор");
        System.out.println("  >>4. Видеокарта");
        System.out.println("  >>5. Операционная система");
        int indexComand = scn.nextInt();
        switch (indexComand) {
            case 0: {
                System.out.println("    >>>Введите модель ноутбука:");
                model = scn2.nextLine();
                break;
            }
            case 1: {
                System.out.println("    >>>Введите цвет ноутбука:");
                color = scn2.nextLine();
                break;
            }
            case 2: {
                System.out.println("    >>>Введите ОЗУ ноутбука:");
                ram = scn2.nextInt();
                break;
            }
            case 3: {
                System.out.println("    >>>Введите процессор ноутбука:");
                processor = scn2.nextLine();
                break;
            }
            case 4: {
                System.out.println("    >>>Введите видеокарту ноутбука:");
                videocard = scn2.nextLine();
                break;
            }
            case 5: {
                System.out.println("    >>>Введите операционную систему ноутбука:");
                oc = scn2.nextLine();
                break;
            }
            default: {
                System.out.println("Вы ввели неверный номер команды!");
                break;
            }

        }

        for (NoteBook item : lNoteBook) {
            if (!model.equals("") && item.getModel().equals(model))
                System.out.println(item.toString() + "\n");
            else if (!color.equals("") && item.getColor().equals(color))
                System.out.println(item.toString() + "\n");
            else if (ram != -1 && item.getRam() == ram)
                System.out.println(item.toString() + "\n");
            else if (!processor.equals("") && item.getProcessor().equals(processor))
                System.out.println(item.toString() + "\n");
            else if (!videocard.equals("") && item.getColor().equals(videocard))
                System.out.println(item.toString() + "\n");
            else if (!oc.equals("") && item.getOc().equals(oc))
                System.out.println(item.toString() + "\n");
        }

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер команды:");
            System.out.println("    0. Вывести данные по ноутбукам");
            System.out.println("    1. Добавить данные по ноутбуку");
            System.out.println("    2. Изменить данные по ноутбуку");
            System.out.println("    3. Удалить данные по ноутбуку");
            System.out.println("    4. Задать фильтр");
            System.out.println("    5. Выход");
            int indexComand = scan.nextInt();

            switch (indexComand) {
                case 0: {
                    printNotebook();
                    break;
                }
                case 1: {
                    addNoteBook();
                    break;
                }
                case 2: {
                    editNoteBook();
                    break;
                }
                case 3: {
                    deleteNoteBook();
                    break;
                }
                case 4: {
                    setFilter();
                    break;
                }
                case 5: {
                    return;
                }

                default: {
                    System.out.println("Вы ввели неверный номер команды!");
                    break;
                }

            }

        }
    }
}