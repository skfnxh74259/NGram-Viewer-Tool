package main;
import ngrams.NGramMap;
import browser.NgordnetServer;

public class Main {
    public static void main(String[] args) {
        NgordnetServer hns = new NgordnetServer();

        String wordFile = "./data/ngrams/top_14377_words.csv";
        String countFile = "./data/ngrams/total_counts.csv";
        String synsetFile = "./data/wordnet/synsets11.txt";
        String hyponymFile = "./data/wordnet/hyponyms11.txt";
        NGramMap ngm = new NGramMap(wordFile, countFile);
        WordNet n = new WordNet(synsetFile, hyponymFile);


        hns.startUp();
        hns.register("hyponyms", new HyponymsHandler(n, ngm));
        hns.register("history", new DummyHistoryHandler());
        hns.register("historytext", new DummyHistoryTextHandler());

        System.out.println("Finished server startup! Visit http://localhost:4567/ngordnet.html");
    }
}
