package com.cedz.kata.calculator;

import java.util.*;

public class Calculator {

    public static final String SPACE = " ";

    private static final Map<Integer, Map<String, Operation>> OPERATION_MAP = new TreeMap<>();
    public static final String CLEAR_CHAR = "^";

    static {
        List<Operation>  operations = Arrays.asList(new Addition(), new Subtraction(), new Multiplication(), new Division());

        for  (Operation operation : operations) {

            if(!OPERATION_MAP.containsKey(operation.getPriority())) {
                OPERATION_MAP.put(operation.getPriority(), new HashMap<>());
            }
            OPERATION_MAP.get(operation.getPriority()).put(operation.getSymbol(), operation);
        }

    }


    public Integer compute(String input) {
        List<String> itemsToProcess = new LinkedList<>();
        itemsToProcess.addAll(Arrays.asList(input.split(SPACE)));

        for (Map<String, Operation> prioritizedOperations  : OPERATION_MAP.values()) {
            Operation operation = null;


            Stack<String> computationStack = new Stack<>();

            for (String item : itemsToProcess) {
                if (prioritizedOperations.containsKey(item)) {
                    operation = prioritizedOperations.get(item);
                } else if (operation != null) {
                    String operand1 = computationStack.pop();
                    computationStack.push(operation.operate(operand1, item));
                    operation = null;
                } else {
                    computationStack.push(item);
                }
            }

            itemsToProcess =  new ArrayList<>();
            itemsToProcess.addAll(computationStack);

        }


        return Integer.parseInt(itemsToProcess.get(0));
    }


    private void removeCleared(List<String> operands) {
        operands.removeAll(Arrays.asList(CLEAR_CHAR));
    }

    private void clearItem(List<String> operands, int i) {
        operands.set(i, CLEAR_CHAR);
    }


    private static abstract class Operation  {
        protected String symbol;
        protected Integer priority;

        public Operation(String symbol, Integer priority) {
            this.symbol = symbol;
            this.priority = priority;
        }

        public  String operate(String op1, String op2) {


            return doOperate(Integer.parseInt(op1), Integer.parseInt(op2));
        }

        public String getSymbol() {
            return symbol;
        }

        public Integer getPriority() {
            return priority;
        }

        protected abstract String doOperate(Integer op1, Integer op2);
    }

    private static class Addition extends  Operation {

        public Addition() {
            super("+",1);
        }

        @Override
        protected String doOperate(Integer op1, Integer op2) {
            return (op1 + op2) + "";
        }
    }

    private static class Subtraction extends  Operation {
        public Subtraction() {
            super("-" , 1);
        }

        @Override
        protected String doOperate(Integer op1, Integer op2) {
            return (op1 - op2) + "";
        }
    }

    private static class Multiplication extends  Operation {

        public Multiplication() {
            super("*" , 0);
        }

        @Override
        protected String doOperate(Integer op1, Integer op2) {
            return (op1 * op2) + "";
        }
    }

    private static class Division extends  Operation {
        public Division() {
            super("/", 0);
        }

        @Override
        protected String doOperate(Integer op1, Integer op2) {
            return (op1 / op2) + "";
        }
    }
}
