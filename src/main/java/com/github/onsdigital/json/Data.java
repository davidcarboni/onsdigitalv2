package com.github.onsdigital.json;

import java.util.ArrayList;
import java.util.List;

import com.github.onsdigital.generator.Folder;

public class Data extends TaxonomyNode {

	public String level;
	public List<TaxonomyNode> breadcrumb = new ArrayList<>();
	public List<TaxonomyNode> children = new ArrayList<>();
	public String lede;
	public String more;

	public Data(Folder folder) {
		super(folder);
		Folder parent = folder;
		while ((parent = parent.parent) != null) {
			breadcrumb.add(0, new TaxonomyNode(parent));
		}
		int index = 1;
		for (Folder child : folder.children) {
			children.add(new Child(child, index++));
		}
	}

}
