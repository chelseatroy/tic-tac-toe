require 'graphviz'
#Graphviz is a gem that draws a diagram for you.
#Full documentation: https://github.com/glejeune/Ruby-Graphviz/
#How to install: 
# -- $sudo gem install graphviz
# -- You also need to dowload graphviz: http://www.graphviz.org/Download..php

@file_to_be_read
@lines_in_the_file = Array.new
@methods_identified_so_far = Array.new
@current_step

@diagram = GraphViz.new( :G, :type => :digraph )

def get_filename
	puts "What is the file name?"
	@file_to_be_read = gets.chomp
end

def open_file(filename)
	@file_to_be_read = File.new(filename, "r")
	
	#Question for Jay:
	#what is the 'r' for in the above parameters? 

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
		is_this_a_step?(command)
		find_moves_for_current_step(command)
	end
end

def is_this_a_step?(line)
	if line.start_with?("step")
		@current_step = line.split[1]
		@methods_identified_so_far << @current_step
		draw_this_step_in_diagram(@current_step)
	end
end

def draw_this_step_in_diagram(step)
	new_node = @diagram.add_nodes(step)
end

def find_moves_for_current_step(line)
	if line.strip.start_with?("response")
	#strip in case of indentation
		does_node_already_exist?(line.split[3])
		draw_connections(line.split[3])
	end
end

def does_node_already_exist?(node)
	if !(@methods_identified_so_far.include?(node))
		@methods_identified_so_far << node
		new_node = @diagram.add_nodes(node)
	end
end

def draw_connections(response)
	@diagram.add_edges( @current_step, response )
end


get_filename
open_file(@file_to_be_read)
get_out_the_words_to_use_in_the_flowchart
@diagram.output( :png => "your_tuvi_game_diagram.png" )

#The picture of your diagram does not open automatically.
#Instead, it was saved to the same folder that this program is in.
#You can go find it in there and open it like any other picture file. 

