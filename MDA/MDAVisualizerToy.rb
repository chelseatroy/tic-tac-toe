require 'graphviz'
#Graphviz is a gem that draws a diagram for you.
#Full documentation: https://github.com/glejeune/Ruby-Graphviz/
#How to install: 
# -- $sudo gem install graphviz
# -- You also need to download graphviz: http://www.graphviz.org/Download..php

@file_to_be_read
@lines_in_the_file = Array.new
@entities_identified_so_far = Array.new
@current_entity

@MDA = GraphViz.new( :G, :type => :digraph )

#This section defines the global settings for how the picture looks.
#Some settings are conditional on whether the entity is a person/org or a process. 
@MDA.node[:color]    = "black"
@MDA.node[:style]    = "filled"
@MDA.node[:penwidth] = "1"
@MDA.node[:fontsize] = "12"
@MDA.node[:fontcolor]= "black"
@MDA.edge[:fontname] = "Verdana"
@MDA.node[:margin]   = "0.1"

@MDA.edge[:color]    = "#999999"
@MDA.edge[:weight]   = "1"
@MDA.edge[:fontsize] = "8"
@MDA.edge[:fontcolor]= "#777777"
@MDA.edge[:fontname] = "Verdana"
@MDA.edge[:dir]      = "forward"
@MDA.edge[:arrowsize]= "1.0"


def open_file(filename)
	@file_to_be_read = File.new(filename, "r")
	read_file(filename)
	@file_to_be_read.close
end

def read_file(filename)
	while (line = @file_to_be_read.gets)
	  @lines_in_the_file << line
	end
end

def get_out_the_words_to_use_in_the_flowchart
	@lines_in_the_file.each do |command|
		identify_all_the_entities(command)
	end
end

def identify_all_the_entities(line)
	if line.start_with?("def")
		this_entity = line.strip.split(/,|\(|\s/).map(&:strip).reject(&:empty?)[1]
		@entities_identified_so_far << this_entity
		draw_this_entity_in_diagram(this_entity)
	end
end

def draw_this_entity_in_diagram(entity)	
	label_as_an_actor_or_a_process(entity)
	new_node = @MDA.add_nodes(entity)
end

def label_as_an_actor_or_a_process(entity)
	if entity[0..0] =~ /[A-Z]/
		@MDA.node[:shape] = "egg"
		check_for_unknown_actors(entity)
	else
		@MDA.node[:shape] = "box"
		check_for_unknown_processes(entity)
	end
end

def check_for_unknown_actors(entity)
	if entity.include?("Unknown")
		@MDA.node[:fillcolor]= "tomato"
		@MDA.node[:fontcolor]= "white"
	else 
		@MDA.node[:fillcolor]= "yellow"
		@MDA.node[:fontcolor]= "black"
	end	
end

def check_for_unknown_processes(entity)
	if entity.include?("unknown")
		@MDA.node[:fillcolor]= "tomato"
		@MDA.node[:fontcolor]= "white"
	else 
		@MDA.node[:fillcolor]= "aquamarine"
		@MDA.node[:fontcolor]= "black"
	end
end

def set_current_entity(line)
	if line.start_with?("def")
		@current_entity = line.strip.split(/,|\(|\s/).map(&:strip).reject(&:empty?)[1]
	end
end

def identify_all_the_connections
	@lines_in_the_file.each do |command|
		set_current_entity(command)
		are_we_inside_the_entity?(command)
	end
end

def are_we_inside_the_entity?(line)
	if !(line.strip.start_with?("def"))
		check_for_entities_inside_entities(line)
	end
end

def check_for_entities_inside_entities(line)
	line.strip.split(/,|\(|\s/).map(&:strip).reject(&:empty?).each do |word|
		if @entities_identified_so_far.include?(word)
			draw_connections(word)
		end
	end
end

def draw_connections(entity_name)
	@MDA.add_edges( @current_entity, entity_name )
end

def main
	open_file("MDA_Interface.rb")
	get_out_the_words_to_use_in_the_flowchart
	identify_all_the_connections
	@MDA.output( :png => "MDA.png" )
end

main

#The picture of your diagram does not open automatically.
#Instead, it was saved to the same folder that this program is in.
#You can go find it in there and open it like any other picture file. 
#Yes, this is annoying. I'm trying to figure out how to make the image open automatically
#after the program runs. 

