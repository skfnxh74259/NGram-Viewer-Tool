# NGram Viewer and WordNet Analysis Tool

## Overview

Developed a Java-based application for exploring historical word usage trends and semantic relationships using the Google NGram dataset and WordNet lexical database. Built backend systems to process large-scale language datasets, retrieve word frequency histories, and identify hyponym relationships through graph traversal algorithms.

The project combined data processing, graph algorithms, and time-series analysis to enable interactive exploration of language evolution and word relationships.

## Tools & Technologies

* Java
* WordNet
* Google NGram Dataset
* Graph Data Structures
* Depth-First Search (DFS)
* Object-Oriented Programming (OOP)
* Git/GitHub

## Skills Demonstrated

* Data Processing
* Time Series Analysis
* Graph Algorithms
* Data Structures
* Object-Oriented Programming
* Backend Development
* Information Retrieval
* Language Data Analysis
* Recursive Algorithms
* Software Engineering

## Project Highlights

* Processed historical word frequency data from the Google NGram dataset
* Built a directed graph representation of WordNet semantic relationships
* Implemented recursive graph traversal to identify hyponym relationships
* Developed query functionality for retrieving common hyponyms across multiple words
* Ranked words by historical usage frequency over user-specified time ranges
* Integrated language trend analysis with semantic relationship exploration

## Objective

The goal of this project was to create an interactive language analysis tool capable of exploring historical word usage patterns and semantic relationships between words using large-scale linguistic datasets.

## Dataset

The project utilized two primary datasets:

### Google NGram Dataset

* Historical word frequency counts
* Multi-year word usage trends
* Large-scale language usage records

### WordNet Lexical Database

* Synsets (groups of synonymous words)
* Hyponym relationships
* Directed semantic graph structure

## Methodology

### Data Processing

* Parsed WordNet synset and hyponym files
* Loaded historical word frequency data from the Google NGram dataset
* Constructed efficient lookup structures using HashMaps
* Organized semantic relationships into graph-based representations

### Graph Construction

Built a directed graph where:

* Nodes represented WordNet synsets
* Edges represented hyponym relationships
* Graph traversal enabled semantic relationship discovery

### Hyponym Retrieval

Implemented recursive graph traversal to:

* Locate word synsets
* Traverse descendant nodes
* Retrieve all associated hyponyms
* Identify common hyponyms across multiple query terms

### Historical Frequency Analysis

Integrated NGram frequency data to:

* Calculate historical word usage counts
* Aggregate usage statistics over specified time periods
* Rank words by total frequency
* Return top-k most frequently used semantic matches

### Query Processing

Developed backend handlers capable of:

* Processing user search requests
* Retrieving semantic relationships
* Filtering results by time range
* Ranking results based on historical popularity

## Results

### Key Functionality

* Retrieved semantic word relationships through WordNet graph traversal
* Identified common descendants between multiple search terms
* Ranked words by historical usage frequency
* Supported top-k query retrieval for language trend exploration
* Enabled interactive analysis of word usage across time

### Key Findings

* Graph-based representations efficiently model semantic relationships between words.
* Historical word frequencies provide valuable context for ranking language concepts.
* Combining WordNet and NGram datasets enables both semantic and temporal analysis.
* Recursive graph traversal effectively discovers descendant word relationships.

## Key Takeaways

* Large language datasets can be combined to support powerful information retrieval systems.
* Graph algorithms are effective for modeling and exploring semantic networks.
* Time-series word frequency data provides insight into language evolution.
* Efficient data structures significantly improve query performance on large datasets.
* Integrating multiple data sources can enhance analytical capabilities and user experience.
