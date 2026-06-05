package main;
import java.util.*;
import edu.princeton.cs.algs4.In;
import org.apache.commons.lang3.ArrayUtils;

public class WordNet {
    private DirectedGraph g;
    private Map<Integer, String> transformSynsets;
    public WordNet(String synsetsText, String hyponymsText) {
        transformSynsets = new HashMap<>();
        g = new DirectedGraph();
        parseSyns(synsetsText);
        parseHyps(hyponymsText);
    }
    private void parseSyns(String synsetsText) {
        In in = new In(synsetsText);
        while (in.hasNextLine()) {
            String[] sections = in.readLine().split(",");
            int synsetId = Integer.parseInt(sections[0]);
            transformSynsets.put(synsetId, sections[1]);
        }
        in.close();
    }
    private void parseHyps(String hyponymsText) {
        In in = new In(hyponymsText);
        while (in.hasNextLine()) {
            String[] sections = in.readLine().split(",");
            int hypernymId = Integer.parseInt(sections[0]);
            for (int i = 1; i < sections.length; i++) {
                int hyponymId = Integer.parseInt(sections[i]);
                g.addEdge(hypernymId, hyponymId);
            }
        }
        in.close();
    }
    public List<String> commonHyps(List<String> words) {
        Set<String> commonHyponyms = new HashSet<>();
        //Initial common hyponyms is just hyponyms of first word
        if (!words.isEmpty()) {
            String initialWord = words.get(0);
            commonHyponyms.addAll(new HashSet<>(getHyp(initialWord)));
        }
        for (int i = 1; i < words.size(); i++) {
            String currWord = words.get(i);
            Set<String> currWordHyps = new HashSet<>(getHyp(currWord));
            commonHyponyms.retainAll(currWordHyps);
        }
        return new ArrayList<>(commonHyponyms);
    }

    public List<String> getHyp(String word) {
        // find id for word
        // if doesn't exist -> return empty set
        List<String> hyponyms = new ArrayList<>();
        List<Integer> synsetIds = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : transformSynsets.entrySet()) {
            String value = entry.getValue();
            String[] values = value.split(" ");
            if (ArrayUtils.contains(values, word)) {
                synsetIds.add(entry.getKey());
            }
        }
        //if word does not exist return empty set
        if (synsetIds.isEmpty()) {
            return hyponyms;
        }
        //recursion
        for (Integer synsetId : synsetIds) {
            getHypHelper(synsetId, hyponyms);
        }

        return hyponyms;
    }

    private void getHypHelper(Integer id, List<String> hyponyms) {
        String synsetLine = transformSynsets.get(id);
        if (synsetLine != null) {
            String[] sections = synsetLine.split(" ");
            for (String section : sections) {
                hyponyms.add(section);
            }
        }
        Set<Integer> hyponymIds = g.getAdjacent(id);
        if (hyponymIds == null) {
            return;
        }

        for (Integer hyponymId : hyponymIds) {
            getHypHelper(hyponymId, hyponyms);
        }

    }
    }
