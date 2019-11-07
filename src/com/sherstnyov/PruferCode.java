package com.sherstnyov;

import java.util.*;

public class PruferCode {
    private List<Integer> prufer = new LinkedList<>();
    private Set<Integer> vertices = new HashSet<>();
    private ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    private String adjLists = "";

    public String getAdjacencyLists(String pruferString) {
        for (int i = 0; i < pruferString.length(); i++) {
            prufer.add(Character.getNumericValue(pruferString.charAt(i)));
        }
        for (int i = 0; i < prufer.size() + 2; i++) {
            vertices.add(i);
        }

        int amountOfVertices = vertices.size();
        for (int i = 0; i < amountOfVertices - 2; i++) {
            for (Iterator<Integer> iterator = vertices.iterator(); iterator.hasNext(); ) {
                boolean found = false;
                Integer vertex = iterator.next();
                for (Integer digit : prufer) {
                    if (vertex + 1 == digit) {
                        found = true;
                    }
                }
                if (!found && prufer.size() != 0) {
                    ArrayList<Integer> edge = new ArrayList<>();
                    edge.add(vertex + 1);
                    edge.add(prufer.get(0));
                    edges.add(edge);
                    iterator.remove();
                    prufer.remove(0);
                    break;
                }
            }
        }

        ArrayList<Integer> tempEdge = new ArrayList<>();
        for (Integer vertex : vertices) {
            tempEdge.add(vertex + 1);
        }
        vertices.clear();
        edges.add(tempEdge);

        for (int i = 1; i <= amountOfVertices; i++) {
            adjLists += (i) + ":";
            for (ArrayList<Integer> edge : edges) {
                if (edge.get(0) == i) {
                    adjLists += " " + edge.get(1);
                }
                if (edge.get(1) == i) {
                    adjLists += " " + edge.get(0);
                }
            }
            if (i != edges.size() + 1) {
                adjLists += "\n";
            }
        }

        return adjLists;
    }
}
