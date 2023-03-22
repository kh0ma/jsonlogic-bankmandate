package com.kh0ma.jsonlogicbankmandate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.paukov.combinatorics3.Generator;

public class SimpleTest {

    public static void main(String[] args) {
        // 2 from (A, B, C) and 1 from (A)

        var pairs = List.of(
//                Pair.of(List.of("A", "C", "A"), true),
//                Pair.of(List.of("A", "B", "C"), true),
//                Pair.of(List.of("A", "A", "A"), true),
//                Pair.of(List.of("C", "C", "A"), true),
//                Pair.of(List.of("A", "C", "A"), true),
//                Pair.of(List.of("B", "B", "A"), true),
//                Pair.of(List.of("A", "B", "B"), true),
//                Pair.of(List.of("A", "A", "C"), true),
//                Pair.of(List.of("A", "A", "B"), true),
                Pair.of(List.of("B", "C", "A", "A", "B"), true),
                Pair.of(List.of("B", "B", "B", "C", "C"), false),
                Pair.of(List.of("B", "B", "B"), false),
                Pair.of(List.of("C", "C", "C"), false),
                Pair.of(List.of("C", "C", "B"), false)
        );

        for (var pair : pairs) {
            var actual = test(pair.getLeft());
            var expected = pair.getRight();

            System.out.printf("Expected: %s, Actual: %s \n", expected, actual);
        }
    }

    private static boolean test(List<String> left) {
        return Generator.permutation(left).simple().stream()
                .peek(el -> System.out.printf("Combination Generated: %s \n", el))
                .anyMatch(SimpleTest::test1);
    }

    private static boolean test1(List<String> approvals) {
        List<List<String>> requirement = new ArrayList<>();
        requirement.add(List.of("A", "B", "C"));
        requirement.add(List.of("A", "B", "C"));
        requirement.add(List.of("A"));

        for (String s : approvals) {
            for (int i = 0; i < requirement.size(); i++) {
                if (requirement.get(i).contains(s)) {
                    requirement.remove(i);
                    break;
                }
            }
        }

        return requirement.isEmpty();
    }
}
