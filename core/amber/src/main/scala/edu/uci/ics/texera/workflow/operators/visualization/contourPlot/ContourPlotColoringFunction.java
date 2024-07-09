package edu.uci.ics.texera.workflow.operators.visualization.contourPlot;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContourPlotColoringFunction {
    HEATMAP("heatmap"),
    LINES("lines"),
    NONE("none");
    private final String coloringMethod;

    ContourPlotColoringFunction(String coloringMethod) {
        this.coloringMethod = coloringMethod;
    }

    @JsonValue
    public String getColoringMethod() {
        return this.coloringMethod;
    }
}