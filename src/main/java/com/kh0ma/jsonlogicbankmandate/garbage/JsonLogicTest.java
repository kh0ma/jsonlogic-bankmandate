package com.kh0ma.jsonlogicbankmandate.garbage;

import java.util.List;

import io.github.jamsesso.jsonlogic.JsonLogic;
//import io.github.meiskalt7.jsonlogic.JsonLogic;
import com.fasterxml.jackson.databind.ObjectMapper;
//import eu.afse.jsonlogic.JsonLogic;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;
import org.paukov.combinatorics3.Generator;

public class JsonLogicTest {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static final String JSON_LOGIC = """
            {
                    "or": [
                        {
                            "and": [
                                {
                                    "in": [
                                        {
                                            "var": 0
                                        },
                                        [
                                            "A",
                                            "B",
                                            "C"
                                        ]
                                    ]
                                },
                                {
                                    "in": [
                                        {
                                            "var": 1
                                        },
                                        [
                                            "A",
                                            "B",
                                            "C"
                                        ]
                                    ]
                                },
                                {
                                    "===": [
                                        {
                                            "var": 2
                                        },
                                        "A"
                                    ]
                                }
                            ]
                        },
                        {
                            "===": [
                                {
                                    "var": 0
                                },
                                "D"
                            ]
                        }
                    ]
                }
            """;

    public static void main(String[] args) {
        // 2 from (A, B, C) and 1 from (A)

        var pairs = List.of(
                Pair.of(List.of("A", "C", "A"), true),
                Pair.of(List.of("A", "B", "C"), true),
                Pair.of(List.of("A", "A", "A"), true),
                Pair.of(List.of("C", "C", "A"), true),
                Pair.of(List.of("A", "C", "A"), true),
                Pair.of(List.of("B", "B", "A"), true),
                Pair.of(List.of("A", "B", "B"), true),
                Pair.of(List.of("A", "A", "C"), true),
                Pair.of(List.of("A", "A", "B"), true),
                Pair.of(List.of("B", "C", "A", "A", "B"), true),
                Pair.of(List.of("D"), true),
                Pair.of(List.of("B", "B", "B", "C", "C"), false),
                Pair.of(List.of("B", "B", "B"), false),
                Pair.of(List.of("C", "C", "C"), false),
                Pair.of(List.of("C", "C", "B"), false)
        );

        for (var pair : pairs) {
            var actual = test(pair.getLeft());
            var expected = pair.getRight();

            System.out.printf("%s | Expected: %s, Actual: %s \n", pair.getLeft(), expected, actual);
        }
    }

    private static boolean test(List<String> left) {
        return Generator.permutation(left).simple().stream()
//                .peek(el -> System.out.printf("Combination Generated: %s \n", el))
                .anyMatch(JsonLogicTest::test1);
    }

    @SneakyThrows
    private static boolean test1(List<String> approvals) {
        JsonLogic jsonLogic = new JsonLogic();

        var json = objectMapper.writeValueAsString(approvals);

        return (boolean) jsonLogic.apply(JSON_LOGIC, json);
    }
}
