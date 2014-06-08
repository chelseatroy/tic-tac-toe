require_relative 'madlibs'

class MadlibsFrontend

	def initialize
		m = Madlibs.new
		puts "Welcome to Madlibs! Let's make a silly story..."
		get_words
	end

	def get_words
		m.s.word_list.each do |word|
			puts "type in a word" + word.to_s
			x = gets.chomp
			m.replace_one(x, word)
		end
		m.s.print_story
	end
end
