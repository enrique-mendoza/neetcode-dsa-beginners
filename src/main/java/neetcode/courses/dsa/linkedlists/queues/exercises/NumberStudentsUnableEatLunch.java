package neetcode.courses.dsa.linkedlists.queues.exercises;

import java.util.HashMap;

public class NumberStudentsUnableEatLunch {

    // Problem definition: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/
    public static int myCountStudents(int[] students, int[] sandwiches) {
        int count = 0;
        int studentsIndex = 0;
        int sandwichesIndex = 0;

        while (studentsIndex < students.length) {
            if (students[studentsIndex] != -1 && sandwiches[sandwichesIndex] != -1 &&
                    students[studentsIndex] == sandwiches[sandwichesIndex]) {
                students[studentsIndex] = -1;
                sandwiches[sandwichesIndex] = -1;

                studentsIndex++;
                sandwichesIndex++;
            } else {
                int last = students[students.length - 1];

                for (int i = students.length - 2; i >= 0; i--) {
                    students[i + 1] = students[i];
                }

                students[0] = last;
            }
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] != -1) {
                count++;
            }
        }

        return count;
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int res = students.length;
        HashMap<Integer, Integer> cnt = new HashMap();

        for (int student : students) {
            if (!cnt.containsKey(student)) {
                cnt.put(student, 0);
            }

            cnt.put(student, cnt.get(student) + 1);
        }

        for (int sandwich : sandwiches) {
            if (cnt.get(sandwich) != null && cnt.get(sandwich) > 0) {
                res--;
                cnt.put(sandwich, cnt.get(sandwich) - 1);
            } else {
                return res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] students = new int[]{1, 1};
        int[] sandwiches = new int[]{0, 1};
        int r = countStudents(students, sandwiches);

        System.out.println(r);
    }
}
