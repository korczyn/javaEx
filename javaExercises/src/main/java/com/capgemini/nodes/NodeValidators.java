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

	/**
	 * Check if node ID is 4 chars long
	 * 
	 * @param node
	 *            - node to check
	 * @return true if ID is 4 chars long
	 * @return false if not
	 */
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

	/**
	 * Checks if node description is shorter than 128 chars
	 * 
	 * @param node
	 *            - node to check
	 * @return true if node decs. is shorter than 128 chars
	 * @return flase if not
	 */
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

	/**
	 * Checks if there is a cycle in graph. In that implementation cycle in
	 * graph exists if every node has predecessors. If at least one does not
	 * have one that means that there is a cycle
	 * 
	 * @param nodes - list of nodes
	 * @return true if there is a cycle
	 * @return false if not
	 */
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

	/**
	 * Check if list of pairs contains given pair. If id's match then list contains given pair
	 * @param pair - pair to check
	 * @return i - index of pair if pair is on a list
	 * @return -1 - if pair is not on a list
	 */
	private static int cointainsPair(Pair pair) {
		for (int i = 0; i < pairs.size(); i++) {
			if (pair.getId().equals(pairs.get(i).getId())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Adding pair to list. If pair exists then its number of succesors is incremented and new succesor is added
	 * @param pair - pair to add to list
	 */
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

	/**
	 * Checks how many succesors each node has.
	 * Only penultimate node can has two subsequent. That means max 2 nodes pointing at it, and not a single node pointing at them.
	 * @param list - list of nodes to check
	 * @return true if every node has one subsequent
	 * @return true if penultimate node has two subsequent
	 * @return false if node have more than 2 subsequent
	 * @return false if node have two subsequent and it is not penultimate
	 */
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
}

/**
 * 
 * @author MKORCZYN
 * Auxiliary class to help to ensure that only penultimate node can have 2 subsequent nodes
 * Each pair stores node id, number of its succesors and their id's
 *
 */
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
