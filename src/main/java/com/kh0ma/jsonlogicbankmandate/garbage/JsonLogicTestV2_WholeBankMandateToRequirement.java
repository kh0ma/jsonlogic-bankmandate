package com.kh0ma.jsonlogicbankmandate.garbage;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh0ma.jsonlogicbankmandate.mvp.dto.FlowRequirementDto;
import io.github.jamsesso.jsonlogic.JsonLogic;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;

public class JsonLogicTestV2_WholeBankMandateToRequirement {

    public static final ObjectMapper objectMapper = new ObjectMapper();

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
        var pairs = List.of(
                Pair.of(
                        Map.of(
                                "operation", "LOCAL_TRANSFER",
                                "amount", "1000",
                                "currencyCode", "AED"
                        ),
                        "no exact expectation"
                )

        );

        for (var pair : pairs) {
            var actual = test(pair.getLeft());
            var expected = pair.getRight();

            System.out.printf("%s | Expected: %s, Actual: %s \n", objectMapper.writeValueAsString(pair.getLeft()), expected, actual);

            var flowRequirementDto = objectMapper.readValue(actual, FlowRequirementDto.class);

            System.out.println(flowRequirementDto);
        }
    }

    @SneakyThrows
    private static String test(Map request) {
        var jsonLogic = new JsonLogic();

//        var json = objectMapper.writeValueAsString(request);
        return (String) jsonLogic.apply(JSON_LOGIC, request);
    }

}
