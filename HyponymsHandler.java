package main;
import browser.NgordnetQueryHandler;
import browser.NgordnetQuery;
import java.util.*;
import ngrams.NGramMap;
import ngrams.TimeSeries;
public class HyponymsHandler extends NgordnetQueryHandler {
    private NGramMap ngm;
    private WordNet wordNet;
    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        int k = q.k();
        List<String> commonHyponyms = listGetHyps(words);
        if (k == 0) {
            Collections.sort(commonHyponyms);
            return commonHyponyms.toString();
        }
        List<String> kHyponyms = kListHyps(commonHyponyms, startYear, endYear, k);
        Collections.sort(kHyponyms);
        return kHyponyms.toString();


    }
    public HyponymsHandler(WordNet n, NGramMap ngm) {
        this.wordNet = n;
        this.ngm = ngm;
    }
    public List<String> listGetHyps(List<String> words) {
        return wordNet.commonHyps(words);
    }
    public List<String> kListHyps(List<String> hyponyms, int startYear, int endYear, int k) {
        // ngm -> word to timeseries
        Map<String, Double> ts = specificYearsHyps(hyponyms, startYear, endYear);
        List<Map.Entry<String, Double>> wordsInOrder = ts.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).toList();
        List<String> kOrderedWords = new ArrayList<>();
        for (int i = 0; i < Math.min(k, wordsInOrder.size()); i++) {
            kOrderedWords.add(wordsInOrder.get(i).getKey());
        }
        return kOrderedWords;
    }
    public Map<String, Double> specificYearsHyps(List<String> hyponyms, int startYear, int endYear) {
        Map<String, Double> countWordWeight = new HashMap<>();
        for (String hyponym : hyponyms) {
            TimeSeries wordCount = ngm.countHistory(hyponym, startYear, endYear);
            Collection<Double> numCounts = wordCount.values();
            double totalCount = 0;
            for (double numCount: numCounts) {
                totalCount += numCount;
            }
            if (totalCount != 0) {
                countWordWeight.put(hyponym, totalCount);
            }
        }
        return countWordWeight;
    }
}


