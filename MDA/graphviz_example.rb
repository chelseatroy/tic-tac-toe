require 'graphviz'

# Create a new graph
g = GraphViz.new( :G, :type => :digraph )

# Create two nodes
hello = g.add_nodes( "Hello" )
world = g.add_nodes( "World" )
conquerer = g.add_nodes("Conquerer")

# Create an edge between the two nodes
g.add_edges( hello, world )
g.add_edges( hello, conquerer )
g.add_edges( conquerer, hello )

# Generate output image
g.output( :png => "gviztest1.png" )