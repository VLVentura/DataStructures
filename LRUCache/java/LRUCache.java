package LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

	private static final int CAPACITY = 10;

	private int actualSize;
	private Map<K, Node<K, V>> map;
	private DoublyLinkedList<K, V> linkedList;

	public LRUCache(){
		this.map = new HashMap<>();
		this.linkedList = new DoublyLinkedList<>();
	}

	public void put(K id, V data){
		// update the node
		if(map.containsKey(id)){
			Node<K, V> node = this.map.get(id);
			node.setData(data);
			update(node);
			return;
		}

		Node<K, V> node = new Node<>(id, data);
		// we insert into the cache + set it to be the head node
		if(this.actualSize < CAPACITY){
			++this.actualSize;
			add(node);
		}
		// if the cache is full we need to remove the las item + set it to be the head node
		else{
			removeTail();
			add(node);
		}

	}

	private void add(Node<K, V> node){
		// the node will be the new head
		node.setNextNode(this.linkedList.getHeadNode());
		// its the head node, it has no previous node
		node.setPreviousNode(null);

		// update the previous head
		if(linkedList.getHeadNode() != null){
			linkedList.getHeadNode().setPreviousNode(node);
		}

		// set the head to be the new node
		linkedList.setHeadNode(node);

		// if there's only 1 node in the list, the head is equal to the tail
		if(linkedList.getTailNode() == null){
			linkedList.setTailNode(node);
		}

		// we have to update the map with the new node
		this.map.put(node.getId(), node);
	}

	private void removeTail(){
		// get node from the map
		Node<K, V> lastNode = this.map.get(this.linkedList.getTailNode().getId());

		// the new tail is the previous node
		this.linkedList.setTailNode(linkedList.getTailNode().getPreviousNode());

		// set the next node to be a NUll
		if(this.linkedList.getTailNode() != null){
			this.linkedList.getTailNode().setNextNode(null);
		}

		// avoid obsolete references to the garbage collector
		lastNode = null;
	}

	public V get(K id){
		// the map does not contain the item
		if(!this.map.containsKey(id)){
			return null;
		}

		Node<K, V> node = this.map.get(id);
		// move to te head (frequently visited item)
		update(node);
		return node.getData();
	}

	// this method move the given node to te front (to the head)
	private void update(Node<K, V> node){
		Node<K, V> previoudNode = node.getPreviousNode();
		Node<K, V> nextNode = node.getNextNode();

		// if it's a middle node in the list
		if(previoudNode != null){
			previoudNode.setNextNode(nextNode);
		}
		// it's the head node
		else{
			this.linkedList.setHeadNode(nextNode);
		}
		// it's not the tail node
		if(nextNode != null){
			nextNode.setPreviousNode(previoudNode);
		}
		// it's the tail node
		else{
			this.linkedList.setTailNode(previoudNode);
		}

		// we have to mode the node to te front
		add(node);
	}

	public void show(){
		Node<K, V> actualNode = this.linkedList.getHeadNode();

		while(actualNode != null){
			System.out.print(actualNode.getData() + " -> ");
			actualNode = actualNode.getNextNode();
		}
		System.out.println("NULL");
	}
}
