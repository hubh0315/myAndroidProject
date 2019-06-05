package com.example.myapplication.module;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

public class LayoutMap {

    private String numberOfVertices;
    private List<Vertex> vertices;


    public void addVertex(Vertex vertex){
        if (vertex == null){
            return;
        }
        if (vertices == null){
            vertices = new ArrayList<>();
        }
        vertices.add(vertex);
    }

    public String getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(String numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }
}
