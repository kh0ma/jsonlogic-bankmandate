package com.kh0ma.jsonlogicbankmandate.mvp;


public class FlowOverrideHolder {

    public static final String FLOW_OVERRIDE = """
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
}
