class StoppingByWoods

	def initialize
		@word_list = {1=>"noun (plural)",2=>"verb",3=>"adjective"}
	end

	def print_story
		puts "Whose "
		+ @word_list[1].to_s + " these are, I think I know."
	end

end