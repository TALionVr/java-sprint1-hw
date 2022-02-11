package github.trofimov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int aspiration = 10000;

            while (true) {
                printMenu();
                System.out.print("Ваш выбор: ");
                int command = scanner.nextInt();
                if (command == 1) {
                    while (true) {
                        System.out.print("Выберите месяц: ");
                        int numberOfMonth = scanner.nextInt();
                        System.out.print("Выберите день: ");
                        int day = scanner.nextInt();
                        System.out.print("Введите кол-во шагов: ");
                        int numberOfStep = scanner.nextInt();
                        if (numberOfMonth < 13 && numberOfMonth > 0 && day > 0 && day < 31 && numberOfStep > 0) {
                            stepTracker.dataEntry(numberOfMonth, day, numberOfStep);
                            break;
                        } else {
                            System.out.println("Проверь правильности данных!");
                        }
                    }
                } else if (command == 2) {
                        while (true) {
                        System.out.print("Выберите месяц, за который хотите узнать статистику: ");
                        int numberOfMonth = scanner.nextInt();
                        if (numberOfMonth < 13 && numberOfMonth > 0) {
                            stepTracker.statistics(numberOfMonth, aspiration);
                            break;
                        } else {
                            System.out.println("Проверь правильность данных!");
                        }
                    }
                } else if (command == 3) {

                    System.out.println("Сейчас цель по количеству шагов в день: " + aspiration);
                    System.out.println("Вы хотите ее изменить? Введите Да/Нет");

                    String answer = scanner.next();
                    if (answer.equals("Да")) {
                        while (true) {
                            System.out.print("Введите новую цель: ");
                            aspiration = scanner.nextInt();
                            if (aspiration < 0) {
                                System.out.println("Введённое значение не должно быть отрицательным!");
                            } else {
                                System.out.println("Новое значение сохранено.");
                                break; }
                        }

                    } else if (answer.equals("Нет")) {
                            System.out.println("Цель осталась прежней.");

                    }  else {
                        System.out.println("Уточните решение!");
                    }

                } else if (command == 4) {
                    System.out.println("До встречи");
                    break;
                } else {
                    System.out.println("Проверь правильность ввода команды!");
                  }
                    }
            }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за день.");
        System.out.println("2 - Узнать статистику за месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("4 - Выйти из приложения.");
    }

    }





