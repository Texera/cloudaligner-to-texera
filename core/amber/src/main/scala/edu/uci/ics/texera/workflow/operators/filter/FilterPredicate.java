package edu.uci.ics.texera.workflow.operators.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.uci.ics.texera.workflow.common.WorkflowContext;
import edu.uci.ics.texera.workflow.common.tuple.Tuple;

public class FilterPredicate {

    @JsonProperty(value = "attribute", required = true)
    public String attribute;

    @JsonProperty(value = "condition", required = true)
    public ComparisonType condition;

    @JsonProperty(value = "value", required = true)
    public String value;


    @JsonIgnore
    public boolean evaluate(Tuple tuple, WorkflowContext context) {
        String tupleValue = tuple.getField(this.attribute).toString().trim();

        try {
            double doubleTupleValue = Double.parseDouble(tupleValue);
            double doubleValue = Double.parseDouble(value);

            switch (condition) {
                case EQUAL_TO:
                    return doubleTupleValue == doubleValue;
                case GREATER_THAN:
                    return doubleTupleValue > doubleValue;
                case GREATER_THAN_OR_EQUAL_TO:
                    return doubleTupleValue >= doubleValue;
                case LESS_THAN:
                    return doubleTupleValue < doubleValue;
                case LESS_THAN_OR_EQUAL_TO:
                    return doubleTupleValue <= doubleValue;
                case NOT_EQUAL_TO:
                    return doubleTupleValue != doubleValue;
            }
            return false;
        } catch (NumberFormatException e) {
            switch (condition) {
                case EQUAL_TO:
                    return tupleValue.equalsIgnoreCase(value);
                case GREATER_THAN:
                    return tupleValue.compareToIgnoreCase(value) > 0;
                case GREATER_THAN_OR_EQUAL_TO:
                    return tupleValue.compareToIgnoreCase(value) >= 0;
                case LESS_THAN:
                    return tupleValue.compareToIgnoreCase(value) < 0;
                case LESS_THAN_OR_EQUAL_TO:
                    return tupleValue.compareToIgnoreCase(value) <= 0;
                case NOT_EQUAL_TO:
                    return !tupleValue.equalsIgnoreCase(value);
            }
            return false;
        }

    }

}
