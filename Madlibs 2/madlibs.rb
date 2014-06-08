require_relative 'preamble'
require_relative 'stopping_by_woods'
require_relative 'harry_potter'

class Madlibs

	attr_accessor :s

	def initialize
		takes_in_story 
	end

	def takes_in_story 

		story_list = 
			[Preamble.new, 
			 StoppingByWoods.new,
			 HarryPotter.new
			]

		s = story_list[rand(story_list.length)]
	end

	def replace_one(word, num)
		s.word_hash[num] = word
	end

end

m = Madlibs.new