package com.capgemini.nodes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.nodes.Node;
import com.capgemini.nodes.NodeValidators;

public class NodeTest {

	@Test
	public void testIsIdFourCharsLong(){
		Node node1 = new Node("12345", "qq", "null");
		assertEquals(false, NodeValidators.isIdFourCharsLong(node1));
		Node node2 = new Node("1234", "qq", "null");
		assertEquals(true, NodeValidators.isIdFourCharsLong(node2));
		Node node3 = new Node("123", "qq", "null");
		assertEquals(false, NodeValidators.isIdFourCharsLong(node3));
	}
	
	@Test
	public void testIsDescriptionAtMost128CharsLong(){
		Node node1 = new Node("12345", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "null");
		assertEquals(true, NodeValidators.isDescriptionAtMost128CharsLong(node1));
		Node node2 = new Node("12345", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "null");
		assertEquals(false, NodeValidators.isDescriptionAtMost128CharsLong(node2));
		Node node3 = new Node("12345", "asa", "null");
		assertEquals(true, NodeValidators.isDescriptionAtMost128CharsLong(node3));
	
	}

	@Test
	public void testHaveCyclesTrue(){
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("1111", "qq", "3333"));
		nodes.add(new Node("2222", "qq", "1111"));
		nodes.add(new Node("3333", "qq", "2222"));
		assertEquals(true, NodeValidators.haveCycles(0, nodes));	
		assertEquals(true, NodeValidators.haveCycles(1, nodes));
		assertEquals(true, NodeValidators.haveCycles(2, nodes));	
	}
	
	@Test
	public void testHaveCyclesFalse(){
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("1111", "qq", "null"));
		nodes.add(new Node("2222", "qq", "1111"));
		nodes.add(new Node("3333", "qq", "2222"));
		assertEquals(false, NodeValidators.haveCycles(0, nodes));	
		assertEquals(false, NodeValidators.haveCycles(1, nodes));
		assertEquals(false, NodeValidators.haveCycles(2, nodes));
	}
	
	@Test
	public void testHasTwoSubsequentAndItsOkTrue(){
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0000", "ss", "null"));
		nodes.add(new Node("1111", "ss", "0000"));
		nodes.add(new Node("2222", "ss", "1111"));
		nodes.add(new Node("3333", "ss", "2222"));
		nodes.add(new Node("4444", "ss", "2222"));
		assertTrue(NodeValidators.hasTwoSubsequentAndItsOk(nodes));
	}
	
	@Test
	public void testHasTwoSubsequentAndItsOkFalse(){
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0000", "ss", "null"));
		nodes.add(new Node("1111", "ss", "0000"));
		nodes.add(new Node("2222", "ss", "1111"));
		nodes.add(new Node("3333", "ss", "2222"));
		nodes.add(new Node("4444", "ss", "1111"));
		assertFalse(NodeValidators.hasTwoSubsequentAndItsOk(nodes));
	}
	
	@Test
	public void testHasThreeSubsequent(){
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("0000", "ss", "null"));
		nodes.add(new Node("1111", "ss", "0000"));
		nodes.add(new Node("2222", "ss", "1111"));
		nodes.add(new Node("3333", "ss", "2222"));
		nodes.add(new Node("4444", "ss", "2222"));
		nodes.add(new Node("5555", "ss", "2222"));
		assertFalse(NodeValidators.hasTwoSubsequentAndItsOk(nodes));
	}

}
