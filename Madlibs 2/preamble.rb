class Preamble

	attr_accessor :word_list 

	def initialize
		@word_list = ["noun (plural)","verb","adjective"]
	end

	def print_story
		puts "We the people, this totally isn't working yet."
		+ @word_list[1].to_s + ", in order to "
		+ @word_list[2].to_s + " a more "
		+ @word_list[3].to_s + " union, establish justice and ensure domestic "

		#++", provide for the
		#common "++", promote the general "++" and secure the blessings
		#of "++" to ourselves and our posterity, do ordain and establish
		#this "++" for the United "++" of "++"."
	end

end