package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 * <li>node id should have 4 characters</li>
 * <li>node description can have maximal 128 characters</li>
 * <li>no cycle</li>
 * <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators {

	public static List<Pair> pairs;

	public static boolean isIdFourCharsLong(Node node) {

		try {
			if (node.getId().length() != 4) {
				throw new NodeException("Node id must be 4 chars long");
			}
		} catch (NodeException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public static boolean isDescriptionAtMost128CharsLong(Node node) {
		try {
			if (node.getDescription().length() > 128) {
				throw new NodeException("Node description can be at most 128 char long");
			}
		} catch (NodeException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean haveCycles(List<Node> nodes) {
		try {
			for (Node node : nodes) {
				if (node.getPredecessorId().equals("null")) {
					return false;
				}
			}
			throw new NodeException("There is a cycle in graph");
		} catch (NodeException e) {
			e.printStackTrace();
			return true;
		}
	}

	private static int cointainsPair(Pair a) {
		for (int i = 0; i < pairs.size(); i++) {
			if (a.getId().equals(pairs.get(i).getId())) {
				return i;
			}
		}
		return -1;
	}

	private static void addPairToList(Pair pair) {
		if (pairs.size() == 0) {
			pairs.add(pair);
		} else {
			if (cointainsPair(pair) != -1) {
				Pair p = new Pair(pairs.get(cointainsPair(pair)).getId(), pairs.get(cointainsPair(pair)).getSucc() + 1,
						pairs.get(cointainsPair(pair)).getPreds() + " " + pair.getPreds());
				pairs.add(p);
				pairs.remove(cointainsPair(pair));
			} else {
				pairs.add(pair);
			}
		}
	}

	public static boolean hasTwoSubsequentAndItsOk(List<Node> list) {
		try {
			pairs = new ArrayList<Pair>();
			for (int i = 0; i < list.size(); i++) {
				Pair p = new Pair(list.get(i).getPredecessorId(), 1, list.get(i).getId());
				addPairToList(p);
			}

			for (int i = 0; i < pairs.size(); i++) {
				if (pairs.get(i).getSucc() > 2) {
					throw new NodeException("Node has " + pairs.get(i).getSucc() + " succesors");
				} else if (pairs.get(i).getSucc() == 2) {
					String[] tmp = pairs.get(i).getPreds().split(" ");
					for (int j = 0; j < pairs.size(); j++) {
						for (int z = 0; z < tmp.length; z++) {
							if (pairs.get(j).getId().equals(tmp[z])) {
								throw new NodeException("Node has 2 succesors and it's not penultimate");
							}
						}
					}

				}
			}
		} catch (NodeException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<Node>();

		nodes.add(new Node("0000", "ss", "null"));
		nodes.add(new Node("1111", "ss", "0000"));
		nodes.add(new Node("2222", "ss", "1111"));
		nodes.add(new Node("3333", "ss", "1111"));
		nodes.add(new Node("4444", "ss", "1111"));

		Collections.sort(nodes, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.getPredecessorId().compareTo(n2.getPredecessorId());
			}
		});
		

		for (int i = 0; i < nodes.size(); i++) {
			Node n = nodes.get(i);
			isIdFourCharsLong(n);
			isDescriptionAtMost128CharsLong(n);
		}
		haveCycles(nodes);
		hasTwoSubsequentAndItsOk(nodes);

	}

}

class Pair {
	private String id;
	private int succ;
	private String preds;

	Pair(String id, int succ, String preds) {
		this.id = id;
		this.preds = preds;
		this.succ = succ;
	}

	public String getPreds() {
		return preds;
	}

	public String getId() {
		return id;
	}

	public int getSucc() {
		return succ;
	}

	public void inc() {
		succ++;
	}
}
