require_relative 'Madlibs'

describe Diary do

	it 'should select a story from the story folder' do
		m = Madlibs.new
		a.takes_in_story
		expect(m.takes_in_story).to eq('somefilename.rb')
	end

	it 'should replace a value in the story hash with an inputted word'
	end

end