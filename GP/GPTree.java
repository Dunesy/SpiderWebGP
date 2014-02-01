package GP;

import java.util.ArrayList;
import java.util.Random;

import Spider.Spider;

public class GPTree 
{
	public static enum TERMINAL_NODES { PROGN2, PROGN3, IS_NEAR_EDGE, IS_NEAR_MID} 
	public static enum EXTERNAL_NODES { CREATE_EDGE, MOVE_TO_NEXT_JUNCTION, ROTATE_CW, ROTATE_CCW, SWITCH_EDGE, TRAVERSE_EDGE_RANDOMLY } 
	public static Random rand = new Random();
	public ArrayList<GPNode> nodes;
	GPNode root;

	GPTree()
	{
		nodes = new ArrayList<GPNode>();
	}
	
	public void Full()
	{
		root = MakeRandomTerminalNode();
		root.depth = 0;
		FullHelper(root);
	}
	
	public GPNode MakeRandomTerminalNode()
	{
		GPNode root = null;
		int start_index = rand.nextInt(4);
		TERMINAL_NODES type = TERMINAL_NODES.values()[start_index];
		if (type == TERMINAL_NODES.IS_NEAR_EDGE)
		{
			root = new IsNearEdge();
		} 
		else if ( type == TERMINAL_NODES.IS_NEAR_MID)
		{
			root = new IsNearMid();
		}
		else if (type == TERMINAL_NODES.PROGN2)
		{
			root = new Progn2();
		}
		else 
		{
			root = new Progn3();
		}
		return root;
	}
	
	public GPNode MakeRandomExternalNode()
	{
		GPNode root = null;
		int start_index = rand.nextInt(6);
		EXTERNAL_NODES type = EXTERNAL_NODES.values()[start_index];
		if (type == EXTERNAL_NODES.CREATE_EDGE)
		{
			root = new IsNearEdge();
		} 
		else if ( type == EXTERNAL_NODES.MOVE_TO_NEXT_JUNCTION )
		{
			root = new IsNearMid();
		}
		else if (type == EXTERNAL_NODES.ROTATE_CCW)
		{
			root = new RotateCCW();
		}
		else if (type == EXTERNAL_NODES.ROTATE_CW) 
		{
			root = new RotateCW();
		}
		else if (type == EXTERNAL_NODES.SWITCH_EDGE)
		{
			root = new SwitchEdge();
		}
		else if (type == EXTERNAL_NODES.TRAVERSE_EDGE_RANDOMLY)
		{
			root = new TraverseEdgeRandomly();
		}
		
		return root;
	}
		
	public void FullHelper(GPNode current)
	{
		current.depth = current.parent.depth + 1;
		if (current.depth == 6) //Choose an External Node to Add on
		{
			for (int i = 0 ; i < current.number_of_children; i++)
			{
				current.children[i] = MakeRandomExternalNode();
				nodes.add(root);
				return;
			}
		}
		else
		{
			for (int i = 0 ; i < current.number_of_children; i++)
			{
				current.children[i] = MakeRandomTerminalNode();
			}
		}
		
		for (int i = 0 ; i < current.number_of_children; i++)
		{
			FullHelper(current.children[i]);
			nodes.add(root);
		}
		
	}	
	
	public void Grow()
	{
		root = MakeRandomTerminalNode();
		
		root.depth = 0;
		GrowHelper(root);
		nodes.add(root);
		
	}
	
	public void GrowHelper(GPNode current)
	{
		GPNode root= null;
		
		for (int i = 0 ; i < current.number_of_children; i++)
		{
			
			if (current.depth >= 2)
				if (rand.nextInt(TERMINAL_NODES.values().length + EXTERNAL_NODES.values().length) < EXTERNAL_NODES.values().length)
				{
					root = MakeRandomExternalNode();
				}
				else
				{
					root = MakeRandomTerminalNode();
				}
			else if (current.depth < 2)
			{
				root = MakeRandomTerminalNode();
			}
			else if (current.depth == 6)
			{
				root = MakeRandomExternalNode();
			}
			root.depth = current.depth + 1;
			current.children[i] = root;
			nodes.add(root);
			
			;
		}
		
		for (int i= 0 ; i < current.number_of_children; i++)
		{			
			GrowHelper(current.children[i]);
		}
	}
	
	public void Evaluate(Spider s)
	{
		root.evaluate(s);
	}
	
	//Mutation
	public static void Mutate(GPTree x)
	{
		//TODO
	}
	
	//Cross Over
	public static void CrossOver(GPTree x, GPTree y)
	{
		
	}
	
}


