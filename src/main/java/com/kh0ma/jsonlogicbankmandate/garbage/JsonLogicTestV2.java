package com.kh0ma.jsonlogicbankmandate.garbage;

import java.util.List;
import java.util.Map;

import com.kh0ma.jsonlogicbankmandate.mvp.dto.ApprovalBuilder;
import io.github.jamsesso.jsonlogic.JsonLogic;
import com.fasterxml.jackson.databind.ObjectMapper;
//import eu.afse.jsonlogic.JsonLogic;
//import io.github.meiskalt7.jsonlogic.JsonLogic;
//import JsonLogicEngine;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;
import org.paukov.combinatorics3.Generator;

public class JsonLogicTestV2 {

    public static final ObjectMapper objectMapper = new ObjectMapper();

/*
    public static final String JSON_LOGIC = """
            {
                     "or": [
                         {
                             "and": [
                                 {
                                     "some": [
                                         [
                                             {
                                                 "groupName": "A",
                                                 "input": {
                                                     "var": 0
                                                 }
                                             },
                                             {
                                                 "groupName": "B",
                                                 "input": {
                                                     "var": 0
                                                 }
                                             },
                                             {
                                                 "groupName": "C",
                                                 "input": {
                                                     "var": 0
                                                 }
                                             },
                                             {
                                                 "individualId": "123",
                                                 "input": {
                                                     "var": 0
                                                 }
                                             }
                                         ],
                                         {
                                             "or": [
                                                 {
                                                     "in": [
                                                         {
                                                             "var": "input.assignedGroups"
                                                         },
                                                         {
                                                             "var": "groupName"
                                                         }
                                                     ]
                                                 },
                                                 {
                                                     "===": [
                                                         {
                                                             "var": "input.individualId"
                                                         },
                                                         {
                                                             "var": "individualId"
                                                         }
                                                     ]
                                                 }
                                             ]
                                         }
                                     ]
                                 },
                                 {
                                     "some": [
                                         [
                                             {
                                                 "groupName": "A",
                                                 "input": {
                                                     "var": 1
                                                 }
                                             },
                                             {
                                                 "groupName": "B",
                                                 "input": {
                                                     "var": 1
                                                 }
                                             },
                                             {
                                                 "groupName": "C",
                                                 "input": {
                                                     "var": 1
                                                 }
                                             },
                                             {
                                                 "individualId": "123",
                                                 "input": {
                                                     "var": 1
                                                 }
                                             }
                                         ],
                                         {
                                             "or": [
                                                 {
                                                     "in": [
                                                         {
                                                             "var": "input.assignedGroups"
                                                         },
                                                         {
                                                             "var": "groupName"
                                                         }
                                                     ]
                                                 },
                                                 {
                                                     "===": [
                                                         {
                                                             "var": "input.individualId"
                                                         },
                                                         {
                                                             "var": "individualId"
                                                         }
                                                     ]
                                                 }
                                             ]
                                         }
                                     ]
                                 },
                                 {
                                     "some": [
                                         {
                                             "var": "2.assignedGroups"
                                         },
                                         {
                                             "===": [
                                                 {
                                                     "var": ""
                                                 },
                                                 "A"
                                             ]
                                         }
                                     ]
                                 }
                             ]
                         },
                         {
                             "some": [
                                 {
                                     "var": "0.assignedGroups"
                                 },
                                 {
                                     "===": [
                                         {
                                             "var": ""
                                         },
                                         "D"
                                     ]
                                 }
                             ]
                         }
                     ]
                 }
            """;
*/

//    public static final String JSON_LOGIC = """
//{
//    "or": [
//        {
//            "and": [
//                {
//                    "some": [
//                        [
//                            {
//                                "groupName": "A",
//                                "input": {
//                                    "var": 0
//                                }
//                            },
//                            {
//                                "groupName": "B",
//                                "input": {
//                                    "var": 0
//                                }
//                            },
//                            {
//                                "groupName": "C",
//                                "input": {
//                                    "var": 0
//                                }
//                            },
//                            {
//                                "individualId": "123",
//                                "input": {
//                                    "var": 0
//                                }
//                            }
//                        ],
//                        {
//                            "or": [
//                                {
//                                    "in": [
//                                        {
//                                            "var": "input.assignedGroups"
//                                        },
//                                        {
//                                            "var": "groupName"
//                                        }
//                                    ]
//                                },
//                                {
//                                    "===": [
//                                        {
//                                            "var": "input.individualId"
//                                        },
//                                        {
//                                            "var": "individualId"
//                                        }
//                                    ]
//                                }
//                            ]
//                        }
//                    ]
//                },
//                {
//                    "some": [
//                        [
//                            {
//                                "groupName": "A",
//                                "input": {
//                                    "var": 1
//                                }
//                            },
//                            {
//                                "groupName": "B",
//                                "input": {
//                                    "var": 1
//                                }
//                            },
//                            {
//                                "groupName": "C",
//                                "input": {
//                                    "var": 1
//                                }
//                            },
//                            {
//                                "individualId": "123",
//                                "input": {
//                                    "var": 1
//                                }
//                            }
//                        ],
//                        {
//                            "or": [
//                                {
//                                    "in": [
//                                        {
//                                            "var": "input.assignedGroups"
//                                        },
//                                        {
//                                            "var": "groupName"
//                                        }
//                                    ]
//                                },
//                                {
//                                    "===": [
//                                        {
//                                            "var": "input.individualId"
//                                        },
//                                        {
//                                            "var": "individualId"
//                                        }
//                                    ]
//                                }
//                            ]
//                        }
//                    ]
//                },
//                {
//                    "some": [
//                        {
//                            "var": "2.assignedGroups"
//                        },
//                        {
//                            "===": [
//                                {
//                                    "var": ""
//                                },
//                                "A"
//                            ]
//                        }
//                    ]
//                }
//            ]
//        },
//        {
//            "some": [
//                {
//                    "var": "0.assignedGroups"
//                },
//                {
//                    "===": [
//                        {
//                            "var": ""
//                        },
//                        "D"
//                    ]
//                }
//            ]
//        },
//        {
//            "===": [
//                {
//                    "var": "0.individualId"
//                },
//                "123"
//            ]
//        }
//    ]
//}
//
//
//            """;
    public static final String JSON_LOGIC = """
        {
             "if": [
                 {
                     "or": [
                         true,
                         {
                             "===": [
                                 {
                                     "var": "operation"
                                 },
                                 "ANY"
                             ]
                         }
                     ]
                 },
                 {
                     "or": [
                         {
                             "if": [
                                 {
                                     "and": [
                                         {
                                             "<=": [
                                                 {
                                                     "var": "amount"
                                                 },
                                                 50000000
                                             ]
                                         },
                                         {
                                             "===": [
                                                 {
                                                     "var": "currencyCode"
                                                 },
                                                 "AED"
                                             ]
                                         }
                                     ]
                                 },
                                 {
                                     "description": "Any ONE from Group B with any ONE from Group C",
                                     "jsonLogic": {
                                         "and": [
                                             {
                                                 "some": [
                                                     {
                                                         "var": "0.assignedGroups"
                                                     },
                                                     {
                                                         "===": [
                                                             {
                                                                 "var": ""
                                                             },
                                                             "B"
                                                         ]
                                                     }
                                                 ]
                                             },
                                             {
                                                 "some": [
                                                     {
                                                         "var": "1.assignedGroups"
                                                     },
                                                     {
                                                         "===": [
                                                             {
                                                                 "var": ""
                                                             },
                                                             "C"
                                                         ]
                                                     }
                                                 ]
                                             }
                                         ]
                                     },
                                     "participation": {
                                         "users": [],
                                         "userGroups": [
                                             "B",
                                             "C"
                                         ]
                                     },
                                     "flowType": "JSON_LOGIC"
                                 }
                             ]
                         },
                         {
                             "if": [
                                 {
                                     "and": [
                                         {
                                             ">": [
                                                 {
                                                     "var": "amount"
                                                 },
                                                 50000000
                                             ]
                                         },
                                         {
                                             "===": [
                                                 {
                                                     "var": "currencyCode"
                                                 },
                                                 "AED"
                                             ]
                                         }
                                     ]
                                 },
                                 {
                                     "description": "Any TWO from Group A with any ONE from Group C",
                                     "jsonLogic": {
                                         "and": [
                                             {
                                                 "some": [
                                                     {
                                                         "var": "0.assignedGroups"
                                                     },
                                                     {
                                                         "===": [
                                                             {
                                                                 "var": ""
                                                             },
                                                             "A"
                                                         ]
                                                     }
                                                 ]
                                             },
                                             {
                                                 "some": [
                                                     {
                                                         "var": "1.assignedGroups"
                                                     },
                                                     {
                                                         "===": [
                                                             {
                                                                 "var": ""
                                                             },
                                                             "A"
                                                         ]
                                                     }
                                                 ]
                                             },
                                             {
                                                 "some": [
                                                     {
                                                         "var": "2.assignedGroups"
                                                     },
                                                     {
                                                         "===": [
                                                             {
                                                                 "var": ""
                                                             },
                                                             "C"
                                                         ]
                                                     }
                                                 ]
                                             }
                                         ]
                                     },
                                     "participation": {
                                         "users": [],
                                         "userGroups": [
                                             "A",
                                             "C"
                                         ]
                                     },
                                     "flowType": "JSON_LOGIC"
                                 }
                             ]
                         }
                     ]
                 }
             ]
         }
            """;


    @SneakyThrows
    public static void main(String[] args) {
        // 2 from (A, B, C) and 1 from (A)

        var pairs = List.of(
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("B","X")).build(),
                        ApprovalBuilder.of(List.of("C","Y")).build(),
                        ApprovalBuilder.of("123", "B","Z").build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("A","X")).build(),
                        ApprovalBuilder.of(List.of("A","Y")).build(),
                        ApprovalBuilder.of(List.of("A","Z")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("B","X")).build(),
                        ApprovalBuilder.of(List.of("B","Y","D")).build(),
                        ApprovalBuilder.of(List.of("B","Z")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("B")).build(),
                        ApprovalBuilder.of(List.of("A")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("B")).build(),
                        ApprovalBuilder.of(List.of("C")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("A")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("C")).build(),
                        ApprovalBuilder.of(List.of("C")).build(),
                        ApprovalBuilder.of(List.of("A")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("C")).build(),
                        ApprovalBuilder.of(List.of("A")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("B")).build(),
                        ApprovalBuilder.of(List.of("B")).build(),
                        ApprovalBuilder.of(List.of("A")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("B")).build(),
                        ApprovalBuilder.of(List.of("B")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("C")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("B")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("B")).build(),
                        ApprovalBuilder.of(List.of("C")).build(),
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("A")).build(),
                        ApprovalBuilder.of(List.of("B")).build()),
                        true
                ),
                Pair.of(List.of(
                        ApprovalBuilder.of(List.of("D")).build()),
                        true
                ),
                Pair.of(List.of(
                                ApprovalBuilder.of(List.of("B","X")).build(),
                                ApprovalBuilder.of(List.of("C","Y")).build(),
                                ApprovalBuilder.of("321", "B","Z").build()),
                        false
                ),
                Pair.of(List.of(
                                ApprovalBuilder.of(List.of("B","X")).build(),
                                ApprovalBuilder.of(List.of("B","X")).build(),
                                ApprovalBuilder.of(List.of("B","X")).build(),
                                ApprovalBuilder.of(List.of("C","Y")).build(),
                                ApprovalBuilder.of(List.of("C","Y")).build()),
                        false
                ),
                Pair.of(List.of(
                                ApprovalBuilder.of(List.of("B","X")).build(),
                                ApprovalBuilder.of(List.of("B","X")).build(),
                                ApprovalBuilder.of(List.of("B","X")).build()),
                        false
                ),
                Pair.of(List.of(
                                ApprovalBuilder.of(List.of("C","X")).build(),
                                ApprovalBuilder.of(List.of("C","X")).build(),
                                ApprovalBuilder.of(List.of("C","X")).build()),
                        false
                ),
                Pair.of(List.of(
                                ApprovalBuilder.of(List.of("C","X")).build(),
                                ApprovalBuilder.of(List.of("C","X")).build(),
                                ApprovalBuilder.of(List.of("B","X")).build()),
                        false
                )
        );

        for (var pair : pairs) {
            var actual = test(pair.getLeft());
            var expected = pair.getRight();

            System.out.printf("%s | Expected: %s, Actual: %s \n", objectMapper.writeValueAsString(pair.getLeft()), expected, actual);
        }
    }

    private static boolean test(List<Map> left) {
        return Generator.permutation(left).simple().stream()
//                .peek(el -> {
//                    try {
//                        System.out.printf("Combination Generated: %s \n", objectMapper.writeValueAsString(el));
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException(e);
//                    }
//                })
                .anyMatch(JsonLogicTestV2::test1);
    }

    @SneakyThrows
    private static boolean test1(List<Map> approvals) {
        var jsonLogic = new JsonLogic();

//        var json = objectMapper.writeValueAsString(approvals);
        return (boolean)jsonLogic.apply(JSON_LOGIC, approvals);
    }

}
